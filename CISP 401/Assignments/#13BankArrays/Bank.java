import java.util.*;
class Bank
{
  static BankAccount [] Bank = new BankAccount [1];
  static int index = -1;
  static int numOfAccts = 0;
  static Scanner reader = new Scanner (System.in);
  static Scanner intReader = new Scanner (System.in);
  static String choice;

  public static void main (String [] args)
  {
    do{

      if(index == -1){System.out.println("No Account Selected");}
      else {System.out.println("\nSelected Account: " + Bank[index].getAcctNum());}
        choice = display();
      switch (choice)
      {
        case "O":
        Bank[numOfAccts] = openAccount();
        index = numOfAccts;
        numOfAccts++;
        checkSize();
        break;

        case "D":
        if (index == -1)
        { System.out.println ("Please select an account first");}
        else
        {
          deposit();
        }
          break;
        case "S":
        select();
          break;
        case "C":
          closeAcct();
          break;
        case "W":
        if (index == -1)
        { System.out.println ("Please select an account first");}
        else
        {
          withdraw();
        }
          break;
        case "L":
        printArr();
        calcTots();
          break;
        case "Q":
        System.out.println ("Have A Great Day:)");
          break;
      }
    }while(choice.compareTo("Q") != 0);
  }

  static BankAccount openAccount()
  {
    String input;
    double bal;
    do {
      System.out.println("Please enter new account number in the following format:");
      System.out.println("XXX-XXX");
      input = reader.nextLine();
    }while(checkDupes(input) == true);
      System.out.println("Please enter the balance:");
      bal = intReader.nextDouble();
      BankAccount newAcct = new BankAccount(input, bal);
      return newAcct;
  }

  static void deposit()
  {
    double newbal = 0;
    System.out.println("Please enter the amount you want to deposit:");
    newbal = intReader.nextDouble() + Bank[index].getBalance();
    Bank[index].setBalance(newbal);
  }

  static void select()
  {
    boolean var;
    System.out.println("Please enter the account number, in the following format:");
    System.out.println("XXX-XXX");
    var = search(reader.nextLine());
    if (var == true)
    {
      System.out.println("Account Number: " + Bank[index].getAcctNum() + " found");
      System.out.println("Current Balance:" + Bank[index].getBalance());
    }
    else if (var == false)
    {
      System.out.println("Account number not found");
    }
  }

  static void closeAcct()
  {
    boolean var = true;
    if (index == -1)
    {
    System.out.println("Please enter the account number, in the following format:");
    System.out.println("XXX-XXX");
    var = search(reader.nextLine());
    }
    if (var == true)
    {
      System.out.println("Account Found... deleting...");
      Bank[index] = Bank[numOfAccts-1];
      numOfAccts--;
    }
    else if (var == false)
    {
      System.out.println("No such account exists");
    }
    }

  static void withdraw()
  {
    double input;
    double limit = Bank[index].getBalance() - 1;
    System.out.println("Please enter the amount you'd like to withdraw");
    do{
    System.out.println("Be Advised|| Your maximum withdraw amount is: $" + limit);
    input = intReader.nextDouble();
  }while (input > Bank[index].getBalance() - 1);
    Bank[index].setBalance(Bank[index].getBalance() - input);
  }

  static void printArr()
  {
      for (int i = 0; i < numOfAccts; i++)
      {
        System.out.println ("Account #: " + Bank[i].getAcctNum() + "  Bal: " + Bank[i].getBalance());
      }
  }

  static void calcTots()
  {
    double tots = 0;
    for (int i = 0; i < numOfAccts; i++)
    {
      tots = tots + Bank[i].getBalance();
    }
    System.out.println("Total Bank Asset: $" + tots);
  }

  static String display()
  {
    System.out.println("These are the available options:");
    System.out.println("O: Open Account");
    System.out.println("D: Deposit");
    System.out.println("S: Select Account");
    System.out.println("C: Close Account");
    System.out.println("W: Withdraw");
    System.out.println("L: List All Accounts");
    System.out.println("Q: Quit");
    return reader.nextLine();

  }

  static boolean checkDupes(String input)
  {
    boolean var = false;
    if(Bank.length > 1)
    {
    outer:
    for (int i = 0; i < numOfAccts; i++)
    {
      if(Bank[i].getAcctNum().equals(input))
      {var = true;
       break outer;}
    }
  }
      return var;
  }

  static boolean search(String input)
  {
    boolean var = false;
    for (int i = 0; i < numOfAccts; i++)
    {
      if(Bank[i].getAcctNum().equals(input))
      {
       index = i;
       var = true;
      }
    }
    return var;
  }

  static void checkSize()
  {
    if (numOfAccts == Bank.length) {Bank = sizeInc(Bank);}
  }

  static BankAccount [] sizeInc (BankAccount [] Bank)
  {
    BankAccount[] temp = new BankAccount [Bank.length*2];
		System.arraycopy(Bank, 0, temp, 0, Bank.length);
		return Bank = temp;
  }

}

class BankAccount
{
  private String accountNum;
  private double balance;

  BankAccount()
  {}

  BankAccount(String accountNum, double balance)
  {
    this.accountNum = accountNum;
    this.balance = balance;
  }
  String getAcctNum (){return accountNum;}
  double getBalance(){return balance;}
  void setBalance(double balance){this.balance = balance;}

}
