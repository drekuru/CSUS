package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import java.io.FileWriter;

import javax.sound.midi.MetaMessage;

public class Stumped {

    private static Stack<Short> stack = new Stack<>();
    private static Vector<String> RAM = new Vector<>();
    private static Vector<opcodeInformation> opcodesInformation = new Vector<>();
    private static Vector<SymbolTable> symbolsTable = new Vector<>();
    private static Vector<InstructionInformation> instructionsInformation = new Vector<>();
    private static int programCounter = 0;
    private static int clockCycles = 1;
    private static String commmandLineInput;

    public static void main(String[] args) throws IOException {
        loadInstructions(args[0]);

        // acts as our first pass, load the symbol table with all labels with their
        // memory location
        loadSymbolTable();

        // acts as our second pass, converts instructions to opcodes and stores it in
        // RAM
        convertInstructionsToOpcodes();

        writeOpcodesToFile(args[1]);

        if (args.length >= 3 && args[2].contains("-l")) {
            printTable();
        }

    }

    private static void loadInstructions(String fileName) throws IOException {

        File assemblerInstructions = new File(fileName);
        Scanner myReader = new Scanner(assemblerInstructions);
        while (myReader.hasNextLine()) {
            String assemblerInstruction = myReader.nextLine();
            if (!assemblerInstruction.contains("v2.0 raw")) {

                InstructionInformation instructionInformation = parseLoadInstruction(assemblerInstruction);
                instructionsInformation.add(instructionInformation);
            }
        }
        myReader.close();
    }

    private static void printTable() {
        System.out.println("*** LABEL LIST ***");
        for (Integer i = 0; i < symbolsTable.size(); i++) {
            System.out.println(symbolsTable.get(i).label + "\t" + symbolsTable.get(i).memoryLocaiton);
        }

        System.out.println("*** MACHINE PROGRAM ***");

        for (Integer i = 0; i < opcodesInformation.size(); i++) {
            System.out.print(extendMemoryLocation(String.valueOf(i)));
            System.out.print(":");
            System.out.print(opcodesInformation.get(i).opcode);
            System.out.print("\t");
            if (opcodesInformation.get(i).label == null) {
                System.out.print(opcodesInformation.get(i).instruction);
            } else {
                System.out.print(opcodesInformation.get(i).label);
            }
            System.out.print(" ");
            if (opcodesInformation.get(i).operand != null) {
                System.out.print(opcodesInformation.get(i).operand);
            }

            System.out.print("\n");

        }

    }

    private static void loadSymbolTable() {
        for (Integer i = 0; i < instructionsInformation.size(); i++) {
            if (instructionsInformation.get(i).label != null) {

                SymbolTable symbolTable = new SymbolTable();
                symbolTable.label = instructionsInformation.get(i).label;
                symbolTable.memoryLocaiton = extendMemoryLocation(String.valueOf(i));
                symbolsTable.add(symbolTable);
            }
        }
    }

    private static String convertShortToHex(short shortValue) {

        // convert our short value into a valid hex number
        String hex = Integer.toHexString(shortValue);

        // turn hex into a 16 bit hex if it is not already
        while (hex.length() < 3) {
            hex = "0" + hex;
        }

        // return the last four elements of the string
        return (hex.substring(hex.length() - 3)).toUpperCase();
    }

    private static InstructionInformation parseLoadInstruction(String assemblerInstruction) {
        InstructionInformation instructionInformation = new InstructionInformation();

        // flag variables to help with parsing
        Boolean isLabel = false;
        Boolean isInstruction = false;
        Boolean isOperand = false;
        Boolean isComment = false;

        /* SECTION WILL ENABLE FLAG VARIABLES */
        if (assemblerInstruction.contains(":")) {
            isLabel = true;
        }

        if (assemblerInstruction.contains(";")) {
            isComment = true;
        }

        String[] assemblerInstructions = assemblerInstruction.split(" ");

        if ((!assemblerInstructions[0].contains(":") || !assemblerInstructions[0].contains(";"))
                && !assemblerInstructions[1].contains(";")) {
            isInstruction = true;
            isOperand = true;
        }

        if ((!assemblerInstructions[0].contains(":") || !assemblerInstructions[0].contains(";"))
                && assemblerInstructions[1].contains(";")) {

            isInstruction = true;
        }

        /* PARSE BASED ON FLAG VARIABLES */
        if (isLabel && isInstruction && isOperand && isComment) {
            instructionInformation.label = assemblerInstructions[0];
            instructionInformation.instruction = assemblerInstructions[1];
            instructionInformation.operand = assemblerInstructions[2];
            instructionInformation.comment = join(assemblerInstructions, " ", 3, assemblerInstructions.length);

        } else if (isLabel && isInstruction && isOperand && !isComment) {
            instructionInformation.label = assemblerInstructions[0];
            instructionInformation.instruction = assemblerInstructions[1];
            instructionInformation.operand = assemblerInstructions[2];
            instructionInformation.comment = null;
        }

        else if (!isLabel && isInstruction && !isOperand && isComment) {
            instructionInformation.label = null;
            instructionInformation.instruction = assemblerInstructions[0];
            instructionInformation.operand = null;
            instructionInformation.comment = join(assemblerInstructions, " ", 1, assemblerInstructions.length);

        }

        else if (!isLabel && isInstruction && isOperand && isComment) {
            instructionInformation.label = null;
            instructionInformation.instruction = assemblerInstructions[0];
            instructionInformation.operand = assemblerInstructions[1];
            instructionInformation.comment = join(assemblerInstructions, " ", 2, assemblerInstructions.length);
        }

        return instructionInformation;
    }

    /* FROM STACK OVER FLOW */
    private static String join(String[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return "";
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + separator.length());

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    private static void convertInstructionsToOpcodes() {
        for (Short i = 0; i < instructionsInformation.size(); i++) {
            String opcode = "";
            switch (instructionsInformation.get(i).instruction) {
                case "NOP":
                    opcode = "0000";
                    break;
                case "HALT":
                    opcode = "0F00";
                    break;
                case "PUSHPC":
                    opcode = "0100";
                    break;
                case "POPPC":
                    opcode = "0200";
                    break;
                case "LD":
                    opcode = "0300";
                    break;
                case "ST":
                    opcode = "0400";
                    break;
                case "DUP":
                    opcode = "0500";
                    break;
                case "DROP":
                    opcode = "0600";
                    break;
                case "OVER":
                    opcode = "0700";
                    break;
                case "DNEXT":
                    opcode = "0800";
                    break;
                case "SWAP":
                    opcode = "0900";
                    break;
                case "PUSHI":
                    opcode = "1" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "PUSH":
                    opcode = "2" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "POP":
                    opcode = "3" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "JMP":
                    opcode = "4" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "JZ":
                    opcode = "5" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "JNZ":
                    opcode = "6" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "IN":
                    opcode = "D000";
                    break;
                case "OUT":
                    opcode = "E" + convertInstructionsToOpcodesHelper(instructionsInformation.get(i));
                    break;
                case "ADD":
                    opcode = "F000";
                    break;
                case "SUB":
                    opcode = "F001";
                    break;
                case "MUL":
                    opcode = "F002";
                    break;
                case "DIV":
                    opcode = "F003";
                    break;
                case "MOD":
                    opcode = "F004";
                    break;
                case "SHL":
                    opcode = "F005";
                    break;
                case "SHR":
                    opcode = "F006";
                    break;
                case "BAND":
                    opcode = "F007";
                    break;
                case "BOR":
                    opcode = "F008";
                    break;
                case "BXOR":
                    opcode = "F009";
                    break;
                case "AND":
                    opcode = "F00A";
                    break;
                case "OR":
                    opcode = "F00B";
                    break;
                case "EQ":
                    opcode = "F00C";
                    break;
                case "NE":
                    opcode = "F00D";
                    break;
                case "GE":
                    opcode = "F00E";
                    break;
                case "LE":
                    opcode = "F00F";
                    break;
                case "GT":
                    opcode = "F010";
                    break;
                case "LT":
                    opcode = "F011";
                    break;
                case "NEG":
                    opcode = "F012";
                    break;
                case "BNOT":
                    opcode = "F013";
                    break;
                case "NOT":
                    opcode = "F014";
                    break;
                default:
                    opcode = "0000";

            }

            opcodeInformation opcodeInformation = new opcodeInformation();
            opcodeInformation.label = instructionsInformation.get(i).label;
            opcodeInformation.opcode = opcode;
            opcodeInformation.instruction = instructionsInformation.get(i).instruction;
            opcodeInformation.operand = instructionsInformation.get(i).operand;
            opcodesInformation.add(opcodeInformation);
        }
    }

    private static String convertInstructionsToOpcodesHelper(InstructionInformation instructionInformation) {
        for (Integer i = 0; i < symbolsTable.size(); i++) {
            if (symbolsTable.get(i).label.contains(instructionInformation.operand)) {
                return symbolsTable.get(i).memoryLocaiton;
            }
        }

        return convertShortToHex(Short.valueOf(instructionInformation.operand));
    }

    private static String extendMemoryLocation(String memoryLocation) {
        while (memoryLocation.length() < 3) {
            memoryLocation = "0" + memoryLocation;
        }
        return memoryLocation;
    }

    private static void writeOpcodesToFile(String fileName) {

        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("v2.0 raw\n");
            for (Integer i = 0; i < opcodesInformation.size(); i++) {
                myWriter.write(opcodesInformation.get(i).opcode);
                myWriter.write("\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

class InstructionInformation {
    public String label;
    public String instruction;
    public String operand;
    public String comment;
}

class SymbolTable {
    public String label;
    public String memoryLocaiton;
}

class opcodeInformation {
    public String label;
    public String opcode;
    public String instruction;
    public String operand;
}
