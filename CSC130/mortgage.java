import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class mortgage {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);// in reader

        double percentage, percentage2, P, P2;// monthly interest rate, and principle
        int years, years2; // number of payments
        // double I; // total amount of interest

        System.out.println("Hello, welcome to the mortgage calculator");

        System.out.print("Please enter the amount borrowed\n:");
        P = input.nextDouble();

        System.out.print("Please enter the yearly interest rate\n:");
        percentage = input.nextDouble();
        double r = percentage / 12; // change into monthly percentage
        r = r / 100; // convert to decimal 98% -> 0.98

        System.out.print("Please enter the loan term (amount of years to pay off the debt)\n:");
        years = input.nextInt();
        int N = years * 12;

        System.out.println("Scenario #2");
        System.out.print("Please enter the amount borrowed\n:");
        P2 = input.nextDouble();

        System.out.print("Please enter the yearly interest rate\n:");
        percentage2 = input.nextDouble();
        double r2 = percentage2 / 12; // change into monthly percentage
        r2 = r2 / 100; // convert to decimal 98% -> 0.98

        System.out.print("Please enter the loan term (amount of years to pay off the debt)\n:"); // are we expecting
                                                                                                 // years or months?
        years2 = input.nextInt();
        int N2 = years2 * 12;

        double c = mortgageCalc(r, P, N);
        double c2 = mortgageCalc(r2, P2, N2);

        double I = totalInterest(c, P, N);
        double I2 = totalInterest(c2, P2, N2);

        display(percentage, c, P, I, years);
        display(percentage2, c2, P2, I2, years2);

        input.close();
    }

    static double mortgageCalc(double r, double P, int N) {

        double c = (r * P * (Math.pow(1 + r, N))) / (Math.pow(1 + r, N) - 1); // calculate
        return c;
    };

    static double totalInterest(double c, double P, int N) {
        double I = (c * N) - P;
        return I;

    };

    static void display(double r, double c, double P, double I, int years) {

        System.out.println("If you have a $" + df2.format(P) + " mortgage at " + df2.format(r) + "%, over " + years
                + " years you will pay $" + df2.format(c) + " per month and it will cost you $" + df2.format(I)
                + " in interest over the lifetime of your mortgage.");
    }
}
