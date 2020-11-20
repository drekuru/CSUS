class Employee
{
  private String fname, lname;
  private Employee bossinfo;
  private Address adrs;

  Employee (String fn, String ln, Employee boss, String city, String state)
  {
    fname = fn;
    lname = ln;
    bossinfo = boss;
    adrs = new Address (city, state);
  }

  String getName()
  {
    return (fname + ", " + lname);
  }

  String getAddress()
  {
    return adrs.getAddress();
  }

  void setBoss(Employee boss)
  {
    bossinfo = boss;
  }

  Employee getBoss()
  {
    return bossinfo;
  }

  void display()
  {
    if ( getBoss() == null)
    {
    System.out.println("Employee " + getName() + " lives in " + getAddress());
    System.out.println("This Employee has no boss\n");
    }
      else{
      System.out.println("Employee " + getName() + " lives in " + getAddress());
      System.out.println("Employee's Boss is: " + getBoss().getName());
        }
  }
}

class Address
{
  private String city, state;

  Address(String city, String state)
  {
    this.city = city;
    this.state = state;
  }

  String getAddress()
  {
    return (city + ", " + state);
  }
}

public class Driver
  {
    public static void main (String[] args)
    {
      Employee boss = new Employee ("Bob","Boss", null, "Sac", "CA");
      Employee emp = new Employee("Slave", "Veggie", boss, "Sac", "KY");
      boss.display();
      emp.display();
    }
  }
