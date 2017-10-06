import java.util.Scanner;
import java.util.InputMismatchException;

public class Variable{
  private String tag;
  private double value;
  private boolean known;
  public Variable(String a){
    tag = a;
    known = false;
  }
  public void setValue(double c){
    value = c;
  }
  public double getValue(){
    return value;
  }
  public void setTag(String b){
    tag = b;
  }
  public String getTag(){
    return tag;
  }
  
  public void validate(){
    Scanner input = new Scanner(System.in); // Reading from System.in
    String val = input.nextLine();
    boolean isValidNum = false;

    if (val.equals("") || val.equals(" ")) { // Empty string check
        System.out.println("Empty");
    } else if (val.matches("-?\\d+(\\.\\d+)?")) { // valid double check
      value = Double.parseDouble(val);
      isValidNum = true;
    } else {
      System.out.println("Number Format error");
    }
  }
 
  
}