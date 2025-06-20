import java.util.*;

public class Main { 
  public static void main(String[] argc){
    Restraunt restraunt = new Restraunt();
    Burger burger = restraunt.createOrder("Veggie");
    burger.prepare();
  }
}

public class Restraunt{
  
  public Burger createOrder(String request){
    BurgerFactory factory = new BurgerFactory();
    return factory.createBurger(request);
  }
}

public class BurgerFactory{
  // Violates open closed principle
  public Burger createBurger(String request){
    if(request == "Veggie"){
      return new VeggieBurger();
    }
    else if(request == "Beef"){
      return new BeefBurger();
    }
    return null;
  }
}

public interface Burger{
  void prepare();
}

public class BeefBurger implements Burger{
  public void prepare(){
    System.out.println("Preparing Beef Burger");
  }
}

public class VeggieBurger implements Burger{
  public void prepare(){
    System.out.println("Preparing Veggie Burger");
  }
}
