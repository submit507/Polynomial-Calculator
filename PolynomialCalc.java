import java.util.Scanner;
import java.util.ArrayList;

public class PolynomialCalc {
    private static ArrayList<Polynomial> polynomials = new ArrayList<Polynomial>();
    private static Scanner scnr = new Scanner(System.in);

    private static void options() {
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

    private static void printPolynomials() {
        System.out.println("Current Polynomials:\n");
        for (int i = 0; i < polynomials.size(); i++) {
            System.out.println(i + 1 + ". " + polynomials.get(i));
        }
    }

    private void create() {
        System.out.println("Creating polynomial!\n");
        polynomials.add(new Polynomial());
    }

    private void add() {
        System.out.println("Please put the number of the polynomial you want to add to:");
        printPolynomials();
        int choice = scnr.nextInt();
        if (choice > polynomials.size()) {
            System.out.println("That number is greater than the number of polynomials!");
            return;
        }

        System.out.println("Please enter the power of the term you want to add to the polynomial:");
        int power = scnr.nextInt();
        System.out.println("Please enter the coefficient of the term you want to add to the polynomial:");
        int coefficient = scnr.nextInt();

        polynomials.get(choice).addTerm(coefficient, power);

    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Polynomial calculator! V1.0\n");

        while (true) {
            options();
            printPolynomials();
        }
    }
}