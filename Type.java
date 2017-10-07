public abstract class Type{ //basic blueprint of type of questions
  protected String name;
  abstract public void equation(); //this is where all variable input and math will be performed
  public String getName(){ //return the name of the type of question
    return name;
  }
}