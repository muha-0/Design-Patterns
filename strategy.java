import java.util.*;

public class Main {
    public static void main(String[] args) {
      paymentService service = new paymentService();
      service.setStrategy(new CashPaymentStrategy());
      service.processPayment();
      service.setStrategy(new VisaPaymentStrategy());
      service.processPayment();
    }
}

class paymentService{
  private Strategy strategy;
  
  void setStrategy(Strategy strategy){
    this.strategy = strategy;
  }
  
  void processPayment(){
    strategy.pay();
  }
}

interface Strategy{
  public void pay();
}

class CashPaymentStrategy implements Strategy{
  public void pay(){
    System.out.println("Paying with Cash");
  }
}

class VisaPaymentStrategy implements Strategy{
  public void pay(){
    System.out.println("Paying with Visa");
  }
}