public class Driver
{
  public static void main (String[] args)
  {
    Drug op = new Drug("Opium", 50.96);
    Drug cnbs = new Drug("Cannabis", 20.25);
    Doctor resident = new Doctor("Heart Surgeon", 4567, 88.49, "Meredith", "Grey");
    Patient pat1 = new Patient (498, "John", "Doe");
    Patient pat2 = new Patient (499, "John", "Smith");
    Hospital myHosp = new Hospital (resident, op, cnbs, pat1, pat2);
    System.out.println(myHosp.getDoc() + ", Oversees Patients:" + myHosp.getPatient(0) + "||" + myHosp.getPatient(1));
  }
}

class Hospital
{
  private Doctor doc;
  private Drug [] drugs = new Drug [2];
  private Patient [] patients = new Patient [2];
  Hospital(){}

  Hospital(Doctor doc, Drug drug, Drug drug2, Patient patient, Patient patient2)
  {
    this.doc = doc;
    drugs[0] = drug;
    drugs[1] = drug2;
    patients[0] = patient;
    patients[1] = patient2;
  }

  String getPatient( int x)
  {
    return patients[x].getname();
  }

  String getDoc()
  {
    return doc.getname();
  }
}

class Doctor extends Person
{
  private String degreeType;
  private int badgeNum;
  private double successRate;

  Doctor(){}

  Doctor(String degreeType, int badgeNum, double successRate, String fn, String ln)
  {
    super (fn, ln);
    this.degreeType = degreeType;
    this.badgeNum = badgeNum;
    this.successRate = successRate;
  }

}

class Drug
{
  private String label;
  private double cost;
  Drug(){}
  Drug(String label, double cost)
  {
    this.label = label;
    this.cost = cost;
  }

  String getDrug()
  {
    return label + ", $" + cost;
  }

}

class Person
{
  private String fn, ln;
  Person(){}
  Person(String fn, String ln)
  {
    this.fn = fn;
    this.ln = ln;
  }

  String getname()
  {
    return fn + ", " + ln;
  }
}

class Patient extends Person
{
  private int iD;
  Patient() {super();}

  Patient(int iD, String fn, String ln)
  {
    super(fn, ln);
    this.iD = iD;
  }

  int getID()
  {
    return iD;
  }
}
