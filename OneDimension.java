public class OneDimension extends Type{
  public OneDimension(String a){
    name = a;
  }
  public void equation(){
    Variable vo = new Variable("Initial velocity:");
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
    
    System.out.println("Vo is: "+vo.getValue());
    System.out.println("Vf is: "+vf.getValue());
    System.out.println("T is: "+t.getValue());
    System.out.println("A is: "+a.getValue());
  }
}
  