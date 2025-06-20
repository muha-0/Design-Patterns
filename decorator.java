import java.util.*;

public class Main {
    public static void main(String[] args) {
        INotifier notifier = new WPNotifier(new FBNotifier(new Notifier()));
        notifier.send("ahmed");
    }
}

interface INotifier{
  void send(String username);
}

class Notifier implements INotifier{
  public void send(String username){
    System.out.println("Sending a message to "+username);
  }
}

abstract class BaseNotifierDecorator implements INotifier{
  final private INotifier wrapper;
  public BaseNotifierDecorator(INotifier wrapper){
    this.wrapper = wrapper;
  }
  public void send(String username){
    wrapper.send(username);
  }
}

class WPNotifier extends BaseNotifierDecorator{
  public WPNotifier(INotifier wrapper){
    super(wrapper);
  }
  public void send(String username){
    super.send(username);
    System.out.println("Sending WP message to "+username);
  }
}

class FBNotifier extends BaseNotifierDecorator{
  public FBNotifier(INotifier wrapper){
    super(wrapper);
  }
  public void send(String username){
    super.send(username);
    System.out.println("Sending FB message to "+username);
  }
}