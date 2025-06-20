import java.util.*;

public class Main{
  public static void main(String[] argc){
    Restraunt restraunt = new BeefBurgerRestraunt();
    Burger burger = restraunt.createBurger();
    burger.prepare();
  }
}

public interface Burger{
  public void prepare();
}

public class VeggieBurger implements Burger{
  public void prepare(){
    System.out.println("Preparing Veggie Burger");
  }
}

public class BeefBurger implements Burger{
  public void prepare(){
    System.out.println("Preparing Beef Burger");
  }
}

public abstract class Restraunt{
  public abstract Burger createBurger();
}

public class BeefBurgerRestraunt extends Restraunt{
  public Burger createBurger(){
    return new BeefBurger();
  }
}

public class VeggieBurgerRestraunt extends Restraunt{
  public Burger createBurger(){
    return new VeggieBurger();
  }
}
