import java.util.ArrayList;

public class OneDimension extends Type{ //place where math and the variable input is done in 1 dimension knematics
  public OneDimension(String a){
    name = a;
  }
  
  public void equation(){ //place math is done
    Variable vo = new Variable("Initial velocity:"); // making the variables
    System.out.println(vo.getTag());
    vo.validate();
    
    Variable vf = new Variable("Final velocity:");
    System.out.println(vf.getTag());
    vf.validate();
    
    Variable t = new Variable("Time:");
    System.out.println(t.getTag());
    t.validate();

    Variable a = new Variable("Acceleration:");
    System.out.println(a.getTag());
    a.validate();
    
    Variable d = new Variable("Distance:");
    System.out.println(d.getTag());
    d.validate();
    
    Variable[] stat = new Variable[5]; //array to check if the variable are known or not
    stat[0]= vo;
    stat[1]= vf;
    stat[2]= t;
    stat[3]= a;
    stat[4]= d;
    
    ArrayList <Variable> knownList = new ArrayList <Variable>(); // getting a list of knowns
    
    System.out.println();
    System.out.println("Known:"); //print out known
    for(int i = 0; i<5; i++){
      if(stat[i].status()){
        knownList.add(stat[i]);
        System.out.println(stat[i].getTag()+stat[i].getValue());
      }
    }
    
    //Actual math part(I have no idea how this will work)
    
    
    //printing all the value
    System.out.println();
    System.out.println("Vo is: "+vo.getValue());
    System.out.println("Vf is: "+vf.getValue());
    System.out.println("T is: "+t.getValue());
    System.out.println("A is: "+a.getValue());
    System.out.println("D is: "+d.getValue());
  }
  
}
  