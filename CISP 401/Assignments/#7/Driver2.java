import java.util.Scanner;

class MyCar{
  String make, model;
  double mpg;
  MyCar(){}
  MyCar(String make, String model, double mpg)
  {
    this.make = make;
    this.model = model;
    this.mpg = mpg;
  }
  void compareMPG(MyCar cartwo)
  {
    System.out.println("This is the most fuel efficient car: ");
    if(this.mpg < cartwo.mpg)
    {
      System.out.println(cartwo.make);
      System.out.println(cartwo.model);
      System.out.println(cartwo.mpg);
    }

    else
    {
      System.out.println(this.make);
      System.out.println(this.model);
      System.out.println(this.mpg);
    }
  }
}

public class Driver2{
  static Scanner reader = new Scanner(System.in);
  static Scanner intReader = new Scanner(System.in);
  public static void main(String[] args)
  {
    System.out.println("Please input make, model, and MPG for Vehicle: ");
    MyCar car1 = new MyCar(reader.nextLine(), reader.nextLine(), intReader.nextDouble());
    System.out.println("Please input make, model, and MPG for Vehicle: ");
    MyCar car2 = new MyCar(reader.nextLine(), reader.nextLine(), intReader.nextDouble());
    car1.compareMPG(car2);
  reader.close();
  intReader.close();
  }
}
