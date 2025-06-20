import java.util.*;

public class Main {
  public static void main(String[] argc) {
    Singelton obj1 = Singelton.getInstance();
    // The instance is created
    Singelton obj2 = Singelton.getInstance();
    // No output
  }
}

class Singelton{ 
  private static volatile Singelton instance;

  private Singelton() {
  }

  public static Singelton getInstance() {
    Singelton result = instance;
    if (result == null) {
      synchronized (Singelton.class) {
        result = instance;
        if (result == null) {
          System.out.println("The instance is created");
          instance = result = new Singelton();
        }
      }
    }
    return result;
  }
}
