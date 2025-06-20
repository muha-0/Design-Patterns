import java.util.*;

public class Main {
    public static void main(String[] args) {
        BaseGameLoader loader =  new FortniteLoader();
        loader.load();
    }
}

abstract class BaseGameLoader{
  //Template method 
  public void load(){
    cleanTemp();
    checkIfReady();
    launchGame();
  }
  public void cleanTemp(){
    System.out.println("Cleaning Temporary Files");
  }
  public abstract void checkIfReady();
  public abstract void launchGame();
}

class FortniteLoader extends BaseGameLoader{
  public void checkIfReady(){
    System.out.println("Checking if all good for Fortnite");
  }
  public void launchGame(){
    System.out.println("Launching Fortnite");
  }
}

class DoomLoader extends BaseGameLoader{
  public void checkIfReady(){
    System.out.println("Checking if all good for Doom");
  }
  public void launchGame(){
    System.out.println("Launching Doom");
  }
}