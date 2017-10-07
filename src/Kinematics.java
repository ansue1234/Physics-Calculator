//This is just a test


//import java.util.InputMismatchException; 
import java.util.Scanner;

public class Kinematics extends Subject{
  private Scanner input;
  public Kinematics(String a){
    title = a;
  }
  public void typeOfQ(){ //Type of question in Kinematics
    System.out.println("Choose category:");
    System.out.println("1 dimension---------------1");
    System.out.println("2 dimensions--------------2");
    
    input = new Scanner(System.in); // Reading from System.in
    String choice = input.nextLine();

    int choiceNum = 0; //input validater
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
    
    if(isValidNum){ // splitting down to variable input in each questions
      switch(choiceNum){
        case 1:
          Type oneDim = new OneDimension("1 Dimension");
          System.out.println(oneDim.getName());
          oneDim.math();
          break;
        case 2:
          System.out.println("Here is 2 Dimensions");
          break;
      }
    }
    
  }
}