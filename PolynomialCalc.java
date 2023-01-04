import java.util.Scanner;
import java.util.ArrayList;

public class PolynomialCalc {
    private ArrayList<Polynomial> polynomials = new ArrayList<Polynomial>();
    private Scanner scnr = new Scanner(System.in);
    private int size = 0;

    private void options() {
        System.out.println("Please select one of the following options:\n");
        System.out.println("1. Create new polynomial");
        System.out.println("2. Add to an existing polynomial");
        System.out.println("3. Remove from an existing polynomial");
        System.out.println("4. Add 2 polynomials");
        System.out.println("5. Subtract 2 polynomials");
        System.out.println("6. Exit");

        int choice = scnr.nextInt();

        switch (choice) {
            case 1:

        }

    }

    private void create() {
        polynomials.add(new Polynomial());

        System.out.println("\nPlease enter the starting power of the polynomial:");
        int power = scnr.nextInt();
        System.out.println("\nPlease enter the starting coefficient of the polynomial:");
        int coefficient = scnr.nextInt();

    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Polynomial calculator! V1.0\n");

        while (true) {

        }

    }

}