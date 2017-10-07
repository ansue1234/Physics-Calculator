import java.util.ArrayList;
import java.lang.Math;

//This is just a test

public class OneDimension extends Type{ //place where math and the variable input is done in 1 dimension kinematics
  private Variable vo;
  private Variable vf;
  private Variable a;
  private Variable t;
  private Variable d;
  private Variable[] stat; 
  private boolean unsolvable = false;
  public OneDimension(String a){
    name = a;
  }
  
  public void math(){ //place result is printed
    vo = new Variable("Initial velocity:"); // making the variables
    System.out.println(vo.getTag());
    vo.validate();
    
    vf = new Variable("Final velocity:");
    System.out.println(vf.getTag());
    vf.validate();
    
    t = new Variable("Time:");
    System.out.println(t.getTag());
    t.validate();

    a = new Variable("Acceleration:");
    System.out.println(a.getTag());
    a.validate();
    
    d = new Variable("Distance:");
    System.out.println(d.getTag());
    d.validate();
    
    stat = new Variable[5]; //array to check if the variable are known or not
    stat[0]= vo;
    stat[1]= vf;
    stat[2]= t;
    stat[3]= a;
    stat[4]= d;
    
    ArrayList <Variable> knownList = new ArrayList <Variable>(); // getting a list of known
    
    System.out.println();
    System.out.println("Known:"); //print out known
    for(int i = 0; i<5; i++){
      if(stat[i].status()){
        knownList.add(stat[i]);
        System.out.println(stat[i].getTag()+stat[i].getValue());
      }
    }
    
    if(knownList.size()<3){
    	unsolvable = true;
    }
    //Actual math part(works but too tedious)
    equations();
    
    //printing all the value
    if(unsolvable == true){ // if t is negative or imaginary or not enough info
    	System.out.println("Impossible to solve, imaginary number for time or needs more info");
    }else{ // if all goes well
	    System.out.println();
	    System.out.println("Results:"); //shows result
	    for(int i = 0; i<5; i++){
	      if(stat[i].status()){
	    	System.out.println(stat[i].getTag()+stat[i].getValue());
	      }
	    }
	    
    }
  }
  
  public void equations(){ // place where value is calculated
	  boolean solved = false;
	  boolean y = true;
	  
	  while(solved==false){ //if not all value is known keep solving 
		  if(!vf.status()){
			  if(vo.status() && a.status() && t.status()){ // finding vf
				  vf.setValue(vo.getValue()+a.getValue()*t.getValue());
				  vf.setStatus(y);
			  }else{
				  vf.setValue(Math.sqrt(vo.getValue()*vo.getValue()+2*a.getValue()*d.getValue()));
				  vf.setStatus(y);
			  }
		  }
		  
		  if(!vo.status()){
			  if(vf.status() && a.status() && t.status()){ // finding vo
				  vo.setValue(vf.getValue()-a.getValue()*t.getValue());
				  vo.setStatus(y);
			  }else if(d.status() && a.status() && t.status()){
				  vo.setValue((d.getValue()-0.5*a.getValue()*t.getValue()*t.getValue())/t.getValue());
				  vo.setStatus(y);
			  }else{
				  vo.setValue(Math.sqrt(vf.getValue()*vf.getValue()-2*a.getValue()*d.getValue()));
				  vo.setStatus(y);
			  }
		  }
		  
		  if(!a.status()){
			  if(vf.status() && vo.status() && t.status()){ // finding a
				  a.setValue((vf.getValue()-vo.getValue())/t.getValue());
				  a.setStatus(y);
			  }else if(d.status() && vo.status() && t.status()){
				  a.setValue((d.getValue()-vo.getValue()*t.getValue())/(0.5*t.getValue()*t.getValue()));
				  a.setStatus(y);
			  }else{
				  a.setValue((vf.getValue()*vf.getValue()-vo.getValue()*vo.getValue())/(2*d.getValue()));
				  a.setStatus(y);
			  }
		  }
		  
		  if(!d.status()){
			  if(vo.status() && a.status() && t.status()){ // finding d
				  d.setValue(vo.getValue()*t.getValue()+0.5*a.getValue()*t.getValue()*t.getValue());
				  d.setStatus(y);
			  }else{
				  d.setValue((vf.getValue()*vf.getValue()-vo.getValue()*vo.getValue())/(2*a.getValue()));
				  d.setStatus(y);
			  }
		  }
		  
		  if(!t.status()){  
			  if(vo.status() && vf.status() && a.status()){ // finding t
				  t.setValue((vf.getValue()-vo.getValue())/a.getValue());
				  t.setStatus(y);
			  }
		  }
		  
		  //if all are solved jump out of loop
		  if(stat[0].status() && stat[1].status() && stat[2].status() && stat[3].status() && stat[4].status()){ 
		  	solved = y;
		  }
	  }
  }
  
}
  