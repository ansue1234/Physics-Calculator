import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Reading from System.in
        titles(); //prints out all the titles (code below main)
        String choice = input.nextLine();

        int choiceNum = 0;
        boolean isValidNum = false;

        if (choice.equals("") || choice.equals(" ")) { // Empty string check
            System.out.println("Empty String");
        } else if (choice.matches("-?\\d+(\\.\\d+)?")) { // valid double check
            //choiceNum = Double.parseDouble(choice);
            choiceNum = Integer.parseInt(choice);
            isValidNum = true;
        } else {
            System.out.println("Number Format error");
        }
        
        if(isValidNum){
          switch(choiceNum){
            case 1:
              Subject projectile = new Kinematics("Kinematics");
              System.out.println(projectile.getTitle());
              projectile.typeOfQ();
              break;
            case 2:
              Subject extortion = new Forces("Forces");
              System.out.println(extortion.getTitle());
              extortion.typeOfQ();
              break;
          }
        }
        

    }
    
    public static void titles () {
      System.out.println("Choose subject: ");
      System.out.println("Kinematics----------------1");
      System.out.println("Forces--------------------2");
    }
}