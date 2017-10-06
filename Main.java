import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Reading from System.in
        System.out.print("How much money do you have: ");

        double amountInDollars = 0;
        String amountInString = input.nextLine();
        boolean isValidNum = false;

        if (amountInString.equals("") || amountInString.equals(" ")) { // Empty string check
            System.out.println("Empty String");
        } else if (amountInString.matches("-?\\d+(\\.\\d+)?")) { // valid double check
            amountInDollars = Double.parseDouble(amountInString);
            isValidNum = true;
        } else {
            System.out.println("Number Format error");
        }

    }
}