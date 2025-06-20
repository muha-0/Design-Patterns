import java.util.*;

public class Main {
  public static void main(String[] args) {
    CommunicationMediator mediator = new CommunicationMediator();

    Employee emp = new Employee();
    Manager mgr = new Manager();

    emp.setMediator(mediator);
    mgr.setMediator(mediator);

    mediator.setEmployee(emp);
    mediator.setManager(mgr);

    emp.sendMessage("Report submitted.");
    mgr.sendMessage("Review received.");

    System.out.println("Employee received: " + emp.recieveMessage());
    System.out.println("Manager received: " + mgr.recieveMessage());
  }
}

interface Mediator {
  public void sendMessageToEmployee(String message);

  public void sendMessageToManager(String message);

  public String EmployeeRecieveMessage();

  public String ManagerRecieveMessage();
}

class CommunicationMediator implements Mediator {
  private Employee employee;
  private Manager manager;
  private final ArrayList<String> ManagerInbox = new ArrayList<>();
  private final ArrayList<String> EmployeeInbox = new ArrayList<>();

  public void sendMessageToEmployee(String message) {
    EmployeeInbox.add(message);
  }

  public void sendMessageToManager(String message) {
    ManagerInbox.add(message);
  }

  public void setEmployee(Employee emp) {
    this.employee = emp;
    EmployeeInbox.clear();
  }

  public void setManager(Manager mgr) {
    this.manager = mgr;
    ManagerInbox.clear();
  }

  public String EmployeeRecieveMessage() {
    return EmployeeInbox.isEmpty() ? "(No messages)" : employeeInbox.remove(0);
  }

  public String ManagerRecieveMessage() {
    return ManagerInbox.isEmpty() ? "(No messages)" : managerInbox.remove(0);
  }
}

class Employee {
  private Mediator mediator;

  public void sendMessage(String message) {
    mediator.sendMessageToManager(message);
  }

  public String recieveMessage() {
    return mediator.EmployeeRecieveMessage();
  }

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }
}

class Manager {
  private Mediator mediator;

  public void sendMessage(String message) {
    mediator.sendMessageToEmployee(message);
  }

  public String recieveMessage() {
    return mediator.ManagerRecieveMessage();
  }

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }
}