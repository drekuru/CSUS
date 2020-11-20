import java.util.Scanner;
class MyPoint{
  private int x;
  public int y;
  private static int noOfObjs;
  MyPoint(){noOfObjs++;}
  MyPoint(int x)
  {
    this.x = x;
    noOfObjs++;
  }

  MyPoint(int x, int y)
  {
    this.x = x;
    this.y = y;
    noOfObjs++;
  }

  void setX(int x)
  {
    this.x = x;
  }

  void setObjs(int newNum)
  {
    noOfObjs = newNum;
  }

  int getX()
  {
    return x;
  }

  static int getObjs()
  {
    return noOfObjs;
  }
}

public class Driver
{
  static Scanner reader = new Scanner(System.in);
  public static void main (String [] args)
  {
      MyPoint point1 = new MyPoint();
      System.out.println("Please enter an x-value for Point2: ");
      MyPoint point2 = new MyPoint(reader.nextInt());
      System.out.println("Please enter an x-value and y-value for Point3: ");
      MyPoint point3 = new MyPoint(reader.nextInt(), reader.nextInt());

      point1.setX(3);
      point1.y = 3;

      System.out.println("Point1 x-val = " + point1.getX());
      System.out.println("Point1 y-val = " + point1.y);
      System.out.println("\n");
      System.out.println("Point2 x-val = " + point2.getX());
      System.out.println("Point2 y-val = " + point2.y);
      System.out.println("\n");
      System.out.println("Point3 x-val = " + point3.getX());
      System.out.println("Point3 y-val = " + point3.y);
      System.out.println("\n");
      System.out.println("Total of Objects = " + MyPoint.getObjs());

  }
}
