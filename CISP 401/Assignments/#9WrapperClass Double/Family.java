import java.util.*;
import javax.swing.*;

class Family {
  double income;
  int children;
  static int c2;

    //Static blocl
    static { Random u=new Random();
             c2 = u.nextInt(7)+1;  }

             //instancce block
    {
      this.children = c2;
    }

    //no args constructor
    Family()
    {
      income = children * 1000;
    }
    //one arg constructor
    Family (double args)
    {
        income = args;
        System.out.println (children);
        System.out.println (income);
    }

    //main
    public static void main (String[] args)
    {
      String input;
      double cnvInput;

      if (c2 < 4)
      {
        Family fam1 = new Family();
      }
      else if (c2 > 3 )
      {
        input = JOptionPane.showInputDialog("Enter your income :)");
        cnvInput = new Double(input).doubleValue();
        Family fam2 = new Family(cnvInput);
      }
    }
}
