import java.util.*;

public class Main{
  public static void main(String[] argc){
    Restraunt restraunt = new ItalianRestraunt();
    BeefBurger burger = restraunt.createBeef();
    burger.prepare();
  }
}

public interface BeefBurger{
  void prepare();
}

public interface VeggieBurger{
  void prepare();
}

public class AmericanBeefBurger implements BeefBurger{
  public void prepare(){
    System.out.println("Preparing AmericanBeefBurger");
  }
}

public class ItalianBeefBurger implements BeefBurger{
  public void prepare(){
    System.out.println("Preparing ItalianBeefBurger");
  }
}

public class AmericanVeggieBurger implements VeggieBurger{
  public void prepare(){
    System.out.println("Preparing AmericanVeggieBurger");
  }
}

public class ItalianVeggieBurger implements VeggieBurger{
  public void prepare(){
    System.out.println("Preparing ItalianVeggieBurger");
  }
}


public abstract class Restraunt{
  public abstract BeefBurger createBeef();
  public abstract VeggieBurger createVeggie();
}

public class ItalianRestraunt extends Restraunt{
  public BeefBurger createBeef(){
    return new ItalianBeefBurger();
  }
  public VeggieBurger createVeggie(){
    return new ItalianVeggieBurger();
  }
}

public class AmericanRestraunt extends Restraunt{
  public BeefBurger createBeef(){
    return new AmericanBeefBurger();
  }
  public VeggieBurger createVeggie(){
    return new AmericanVeggieBurger();
  }
}