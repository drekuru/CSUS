import java.util.*;
import java.io.*;

public class Stasm {

    // array of opcodes
    private static ArrayList<String> opcodes = new ArrayList<>();

    // symbol map
    private static ArrayList<Label> symbolMap = new ArrayList<>();

    // stores incoming assembply code
    private static ArrayList<String> assemblyCode = new ArrayList<>();

    // program counter
    private static Integer pc = 0;

    public static void main(String args[]) throws IOException {

        // read assembly code into String array
        readAssemblyInput(args[0]);

        // init opcodes array with v2.0 raw
        opcodes.add("v2.0 raw");

        // init all labels
        for (int i = 0; i < assemblyCode.size(); i++) {
            checkForLabel(assemblyCode.get(i));
        }

        // generate opcodes
        for (int i = 0; i < pc; i++) {

            // generate opcode
            generateOpcode(assemblyCode.get(i));
        }

        // write to file
        writeFile(args[1]);

        // memory dump if flag
        if (args.length == 3 && args[2].equals("-l"))
            memoryDump();
    }

    // convert instructions to opcodes
    private static void generateOpcode(String input) {

        // POP k
        // split input into opcode and value
        String[] temp = input.split(" ");

        switch (temp[0]) {
            case "NOP":
                opcodes.add("0000");
                break;
            case "HALT":
                opcodes.add("0F00");
                break;
            case "PUSHPC":
                opcodes.add("0100");
                break;
            case "POPPC":
                opcodes.add("0200");
                break;
            case "LD":
                opcodes.add("0300");
                break;
            case "ST":
                opcodes.add("0400");
                break;
            case "DUP":
                opcodes.add("0500");
                break;
            case "DROP":
                opcodes.add("0600");
                break;
            case "OVER":
                opcodes.add("0700");
                break;
            case "DNEXT":
                opcodes.add("0800");
                break;
            case "SWAP":
                opcodes.add("0900");
                break;
            case "PUSHI":
                // get 12 bit sign int in Hex and add
                opcodes.add("1".concat(stringIntTo12Hex(temp[1])));
                break;
            case "PUSH":
                opcodes.add("2".concat(getSymbol(temp[1])));
                break;
            case "POP":
                opcodes.add("3".concat(getSymbol(temp[1])));
                break;
            case "JMP":
                opcodes.add("4".concat(getSymbol(temp[1])));
                break;
            case "JZ":
                opcodes.add("5".concat(getSymbol(temp[1])));
                break;
            case "JNZ":
                opcodes.add("6".concat(getSymbol(temp[1])));
                break;
            case "IN":
                opcodes.add("D000");
                break;
            case "OUT":
                opcodes.add("E000");
                break;
            case "ADD":
                opcodes.add("F000");
                break;
            case "SUB":
                opcodes.add("F001");
                break;
            case "MUL":
                opcodes.add("F002");
                break;
            case "DIV":
                opcodes.add("F003");
                break;
            case "MOD":
                opcodes.add("F004");
                break;
            case "SHL":
                opcodes.add("F005");
                break;
            case "SHR":
                opcodes.add("F006");
                break;
            case "BAND":
                opcodes.add("F007");
                break;
            case "BOR":
                opcodes.add("F008");
                break;
            case "BXOR":
                opcodes.add("F009");
                break;
            case "AND":
                opcodes.add("F00A");
                break;
            case "OR":
                opcodes.add("F00B");
                break;
            case "EQ":
                opcodes.add("F00C");
                break;
            case "NE":
                opcodes.add("F00D");
                break;
            case "GE":
                opcodes.add("F00E");
                break;
            case "LE":
                opcodes.add("F00F");
                break;
            case "GT":
                opcodes.add("F010");
                break;
            case "LT":
                opcodes.add("F011");
                break;
            case "NEG":
                opcodes.add("F012");
                break;
            case "BNOT":
                opcodes.add("F013");
                break;
            case "NOT":
                opcodes.add("F014");
                break;
            case "DW":
                opcodes.add(stringIntTo16Hex(temp[1]));
                break;
        }
    }

    // find symbol in map
    private static String getSymbol(String input) {

        // search symbol map for this symbol and return value
        for (int i = 0; i < symbolMap.size(); i++) {
            if (symbolMap.get(i).label.equals(input)) {
                return symbolMap.get(i).mem;
            }
        }

        return null;
    }

    // parse labels
    private static void checkForLabel(String input) {

        // trim out white space
        input = input.trim();

        // if it starts with ;
        if (input.startsWith(";"))
            return;

        // remove trailing comments
        String[] temp = input.split(";");

        // reassign to work with this string
        input = temp[0].trim();

        // check for labels without opcodes
        if (input.endsWith(":")) {
            // split by :
            String[] symbol = input.split(":");

            // map symbol
            mapSymbol(symbol[0].trim());
            return;
        }

        // System.out.println("In:" + input + " @PC: " + pc);
        // check for opcodes with no labels
        if (!input.contains(":"))
            assemblyCode.set(pc, input);
        else {
            // split by :
            String[] symbol = input.split(":");

            // map symbol
            mapSymbol(symbol[0].trim());

            // push opcode
            assemblyCode.set(pc, symbol[1].trim());
        }
        pc++;
        return;
    }

    // parse string and map the label
    private static void mapSymbol(String input) {
        // create new object and store in array
        Label myLabel = new Label();

        // add values
        myLabel.label = input;
        myLabel.mem = shortTo12Hex(pc);

        // push to arraylist of labels
        symbolMap.add(myLabel);
    }

    // convert short to 12 bit signed hex
    private static String shortTo12Hex(int input) {

        // get short
        String hex = Integer.toHexString((short) input);

        // ensure length is 3
        while (hex.length() < 3) {
            if (input > 2047) {
                hex = "F".concat(hex);
            } else {
                hex = "0".concat(hex);
            }
        }

        return hex.substring(hex.length() - 3);
    }

    // convert short to 16 bit signed hex
    private static String stringIntTo16Hex(String input) {
        // cast to short during conversion
        Short temp = (short) Integer.parseInt(input);

        // convert to 16 bit hex
        String hex = Integer.toHexString(temp);

        // pad with 0's
        hex = "000".concat(hex);

        // trim
        hex = hex.substring(hex.length() - 4);

        return hex;
    }

    // convert string decimal number to string hex "255" -> "0FF"
    private static String stringIntTo12Hex(String myInt) {
        // parse out int
        Short temp = (short) Integer.parseInt(myInt);

        // get hex
        return shortTo12Hex(temp);
    }

    // readfile
    private static void readAssemblyInput(String fileName) throws FileNotFoundException {

        // init file var
        File opcodes = new File(fileName);

        // scanner
        Scanner reader = new Scanner(opcodes);

        while (reader.hasNextLine()) {
            String temp = reader.nextLine().trim();
            // push instruction to memory(RAM)
            // System.out.println(temp);
            assemblyCode.add(temp);
        }

        // close reader
        reader.close();
    }

    // writefile
    private static void writeFile(String fileName) throws IOException {
        // init file
        FileWriter myWriter = new FileWriter(fileName);

        // write opcdes to file
        for (int i = 0; i < opcodes.size(); i++) {
            myWriter.write(opcodes.get(i) + "\n");
        }

        // close writer
        myWriter.close();
    }

    // print a bunch of info
    private static void memoryDump() {
        System.out.println("*** Label List ***");

        // for each label
        for (int i = 0; i < symbolMap.size(); i++) {
            System.out.println(symbolMap.get(i).label + "    " + symbolMap.get(i).mem);
        }

        System.out.println("*** Machine Program ***");

        // for each opcode generate
        System.out.println(opcodes.get(0));
        for (int i = 1; i < opcodes.size(); i++) {

            System.out.println(opcodes.get(i));
        }
    }

    // class for labels
    private static class Label {
        private String label;
        private String mem;
    }
}
