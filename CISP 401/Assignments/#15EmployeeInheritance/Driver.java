import java.util.*;
import java.text.DecimalFormat;
abstract class Employee
{
  protected String fn, ln;
  protected double weeklywage;

  abstract double getHourly();
  abstract void displayWage();
  abstract void setWage(double x);
  abstract double getWage();
  abstract void compPay(int Hours);
  void setFName(String fn)     {this.fn = fn;}
  void setLName(String ln)     {this.ln = ln;}
  String getFullName()         {return fn + ", " + ln;}
  double getWeeklyWage()           {return weeklywage;}
}
class HrEmployee extends Employee
{
  double wage;
  HrEmployee(){}
  HrEmployee(String fn, String ln, double wage)
  {
    setFName(fn);
    setLName(ln);
    this.wage = wage;
  }

  void compPay(int Hours)
  {
    if (Hours > 40)
    {super.weeklywage = (40*wage) + ((Hours-40)*(1.5*wage));}
    else
    {super.weeklywage = Hours*wage;}
  }

  double getWage(){return wage;}

  double getHourly(){return wage;}

  void setWage(double newW){wage = newW;}

  void displayWage(){System.out.println(getFullName() + "       $" + String.format("%.2f", getWage()) + "/hour");}
}
class SEmployee extends Employee
{
  double salary;
  int hours;
  SEmployee(){}
  SEmployee(String fn, String ln, double wage)
  {
    setFName(fn);
    setLName(ln);
    salary = wage;
  }
  void compPay(int Hours)
  {
    super.weeklywage = salary/52;
    this.hours = Hours;
  }
  double getWage(){return salary;}

  double getHourly(){return super.weeklywage/hours;}

  void setWage(double newS){salary = newS;}

  void displayWage(){System.out.println(getFullName() + "       $" + String.format("%.2f",getWage()) + "/year");}
}

public class Driver
{
  static Employee [] Emps = new Employee [1];
  static Scanner reader    = new Scanner (System.in);
  static Scanner intReader = new Scanner (System.in);
  static int numofEmps = 0;
  static String choice;

  public static void main (String [] args)
  {
    do {
          choice = display();
        switch(choice)
        {
          case "N":
          Emps [numofEmps] = newEmp();
          numofEmps++;
          checkSize();
            break;
          case "P":
            printPay();
            break;
          case "R":
            raiseWages();
            break;
          case "L":
            listEmps();
            System.out.println();
            break;
          case "Q":
            System.out.println("See Ya Later\n:)");
            break;
        }

       }while(choice.compareTo("Q") != 0);
  }

  static String display()
  {
    System.out.println("These are the available options:");
    System.out.println("N: New Employee");
    System.out.println("P: Compute Paychecks");
    System.out.println("R: Raise Wages");
    System.out.println("L: List All Employees");
    System.out.println("Q: Quit");
    return reader.nextLine();
  }

  static Employee newEmp()
  {
    Employee emp1 = new HrEmployee();
    String fname, lname, type;
    double wage;
      System.out.println("Please enter First Name of new Employee:");
      fname = reader.nextLine();
      System.out.println("Please enter Last Name of new Employee:");
      lname = reader.nextLine();
      System.out.println(" Hourly or Salaried? (H/S):");
      type = reader.nextLine();
        if (type.equals("S") || type.equals("s"))
        {
          System.out.println("Enter annual salary:");
          wage = intReader.nextDouble();
          emp1 = new SEmployee(fname, lname, wage);
        }
       if (type.equals("H") || type.equals("h"))
        {
          System.out.println("Enter hourly pay:");
          wage = intReader.nextDouble();
          emp1 = new HrEmployee(fname, lname, wage);
        }
        return emp1;
  }

  static void checkSize()
  {if (numofEmps == Emps.length)
    {Emps = sizeInc(Emps);
  }
}

  static Employee [] sizeInc (Employee [] Emps)
  {
    Employee[] temp = new Employee [Emps.length*2];
    System.arraycopy(Emps, 0, temp, 0, Emps.length);
    return Emps = temp;
  }

  static void printPay()
  {
    int hours = 0;
    for (int i = 0; i < numofEmps; i++)
    {
      System.out.println("Enter number of hours worked per week by " + Emps[i].getFullName());
      hours = intReader.nextInt();
      Emps[i].compPay(hours);
      System.out.println("Pay: $" + String.format("%.2f", Emps[i].getWeeklyWage()));
    }
  }

  static void raiseWages()
  {
    double percent;
    System.out.println("Enter percentage increase:");
    percent = intReader.nextDouble();
    percent = percent/100;
    System.out.println("New Wages Are");
    for (int i = 0; i < numofEmps; i++)
    {
      Emps[i].setWage(Emps[i].getWage() + Emps[i].getWage()*percent);
      Emps[i].displayWage();
    }
  }

  static void listEmps()
  {
    System.out.println("List of Employees and Hourly Wages");
    for (int i = 0; i < numofEmps; i++)
    {
      System.out.println(Emps[i].getFullName() + "    $" + String.format("%.2f", Emps[i].getHourly()));
    }
  }
}
