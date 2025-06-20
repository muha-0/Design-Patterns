import java.util.*;
//Client
public class Main { 
  public static void main(String[] argc){
    //Using old app
    Talabat myApp = new Talabat();
    myApp.display("XML data");
    //Using new app
    Talabat2 mynewApp = new Talabat2();
    mynewApp.display("XML data");
  }
}

//Interface
public interface ITalabat{
  void display(String XML);
}

//Old implemetation
public class Talabat implements ITalabat{
  public void display(String XML){
    System.out.println("Using XML");
  }
}

//New Service
public class NewService{
  public void display(String JSON){
    System.out.println("Using JSON");
  }
}

//Adaptor
public class Talabat2 implements ITalabat{
  private NewService service = new NewService();
  public void display(String XML){
    //transform data to JSON here
    String JSON = XML;
    service.display(JSON);
  }
}


