import java.util.Scanner;
//import java.util.InputMismatchException;

public class Variable{ //blue print for variables
  private String tag;
  private double value;
  private boolean known;
  private Scanner input;
  public Variable(String a){ // name of variable
    tag = a;
    known = false;
  }
  public void setValue(double c){ //set value of variable
    value = c;
  }
  public double getValue(){
    return value;
  }
  public void setTag(String b){ // set name of variable
    tag = b;
  }
  public String getTag(){
    return tag;
  }
  public boolean status(){ // return whether the variable is known or not
    return known;
  }
  
  public void validate(){ // checking if the variable is know or unknown
    input = new Scanner(System.in); // Reading from System.in
    String val = input.nextLine();
    //boolean isValidNum = false;

    if (val.equals("") || val.equals(" ")) { // Empty string check
        System.out.println("Empty");
    } else if (val.matches("-?\\d+(\\.\\d+)?")) { // valid double check
      value = Double.parseDouble(val);
      known = true;
     // isValidNum = true;
    } else {
      System.out.println("Number Format error");
    }
  }
  
  
}