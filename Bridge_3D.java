import java.util.*;
//Client -> It's his responsibility to link between abstraction and implementation classes
public class Main { 
  public static void main(String[] argc){
    VisaPayment payment = new VisaPayment(new ItalianRestraunt(new BeefPizza()));
    payment.createTransaction();
  }
}

//The implementation class, does all the work

public abstract class Pizza{
  public abstract void deliver();
}

public class VeggiePizza extends Pizza{
  public void deliver(){
    System.out.println("Delivering VeggiePizza");
  }
}

public class BeefPizza extends Pizza{
  public void deliver(){
    System.out.println("Delivering BeefPizza");
  }
}

//Adding extra dimension, the abstraction class, it delegates the work to the implementation (Pizza)

public abstract class Restraunt{
  protected Pizza pizza;
  protected Restraunt(Pizza pizza){
    this.pizza = pizza;
  }
  public abstract void createOrder();
}

public class ItalianRestraunt extends Restraunt{
  public ItalianRestraunt(Pizza pizza){
    super(pizza);
  }
  public void createOrder(){
    System.out.println("Using the Italian way");
    pizza.deliver();
  }
}

public class AmericanRestraunt extends Restraunt{
  public AmericanRestraunt(Pizza pizza){
    super(pizza);
  }
  public void createOrder(){
    System.out.println("Using the American way");
    pizza.deliver();
  }
}

//Adding an extra dimension for fun

public abstract class Payment{
  protected Restraunt restraunt;
  protected Payment(Restraunt restraunt){
    this.restraunt = restraunt;
  }
  public abstract void createTransaction();
}

public class CashPayment extends Payment{
  public CashPayment(Restraunt restraunt){
    super(restraunt);
  }
  public void createTransaction(){
    System.out.println("Creating a cash transaction");
  }
}

public class VisaPayment extends Payment{
  public VisaPayment(Restraunt restraunt){
    super(restraunt);
  }
  public void createTransaction(){
    System.out.println("Creating a visa transaction");
    restraunt.createOrder();
  }
}