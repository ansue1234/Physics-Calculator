

public abstract class Type{ //basic blueprint of type of questions
  protected String name;
  abstract public void math(); //this is where all variable input and math will be performed
  abstract public void equations();
  public String getName(){ //return the name of the type of question
    return name;
  }
}