import java.util.Scanner;

class RatioInfo{
	private int GPA;
	private int IQ;
	private double percentage;
	private static double totalRatio;

	RatioInfo(int GPA, int IQ)
	{
		this.GPA = GPA;
		this.IQ = IQ;
		calcRatio();
	}

	void calcRatio()
	{
		percentage = IQ/GPA;
		calcTotalRatio(this);
	}

	double getPercentage()
	{	return percentage;}

	String getStatus()
	{
		String stat = null;
			if(percentage > totalRatio/Student.getStudentCount())
			{
				stat = "good";
			}
			else if(percentage <= totalRatio/Student.getStudentCount())
			{
				stat = "bad";
			}
			return stat;
	}

	static void calcTotalRatio( RatioInfo obj)
	{
		totalRatio = totalRatio + obj.percentage;
	}

	double returntotRatio()
	{
		return totalRatio;
	}

}

 class Student{
	private String fname,lname;
	private RatioInfo ratio;
	private static int studentCount;

	Student(){studentCount++;	}

	Student(String fname, String lname)
	{
			this.fname = fname;
			this.lname = lname;
			studentCount++;
	}

	Student(String fname, String lname, int GPA, int IQ)
	{
		this(fname,lname);
		setRatio(GPA, IQ);
		studentCount++;
	}

	void setRatio(int GPA, int IQ)
	{
		ratio = new RatioInfo(GPA, IQ);
	}

	void setName(String fname, String lname)
	{
		this.fname = fname;
		this.lname = lname;
	}
	String getName()
	{return fname + ", " + lname;}

	RatioInfo getRatio( )
	{return ratio;}

	static int getStudentCount()
	{return studentCount;}

	String display()
	{
		return getName() + " || Ratio: " + getRatio().getPercentage() + " || status: " + getRatio().getStatus();
	}
}

public class Driver
{
	static Scanner reader = new Scanner(System.in);
	static Scanner intg = new Scanner(System.in);
	public static void main(String [] args)
	{
		Student stu1 = new Student();
		promptName();
		stu1.setName(reader.nextLine(), reader.nextLine());
		promptRatio();
		stu1.setRatio(intg.nextInt(), intg.nextInt());
		// end of student 1

		promptName();
		Student stu2 = new Student(reader.nextLine(), reader.nextLine());
		promptRatio();
		stu2.setRatio(intg.nextInt(), intg.nextInt());
		//end of student 2

		prompt();
		Student stu3 = new Student(reader.nextLine(), reader.nextLine(), intg.nextInt(), intg.nextInt());
		System.out.println(stu1.display());
		System.out.println(stu2.display());
		System.out.println(stu3.display());
		reader.close();
	}
	static void prompt()
	{
		System.out.println("Please enter student info");
	}
	static void promptName()
	{
		System.out.println("Please enter the student F/L Name");
	}
	static void promptRatio()
	{
		System.out.println("Please enter student GPA and IQ");
	}
}
