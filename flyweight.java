import java.util.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addBook("Ai", "Ahmed", "X", "Black");
        store.addBook("Os", "Aly", "X", "Black");

        store.displayBooks(); 
    }
}


class Book{
  public Book(String name, String author, Booktype type){
    this.name = name;
    this.author = author;
    this.type = type;
  }
  
  String name;
  String author;
  Booktype type;
  public String getName(){
    return name;
  }
}

class Booktype{
  public Booktype(String distributor, String color){
    this.distributor = distributor;
    this.color = color;
  }
  String distributor;
  String color;
}

class BookFactory{
  private static final HashMap<String, Booktype> map = new HashMap<>();
  public static Booktype getBooktype(String distributor, String color){
    if(map.get(distributor+color) == null){
      map.put(distributor + color, new Booktype(distributor,color));
    }
    return map.get(distributor+color);
  }

}

class Store{
  ArrayList<Book> books = new ArrayList<>();

  public void addBook(String name, String author, String distributor, String color){
    Booktype type = BookFactory.getBooktype(distributor,color);
    books.add(new Book(name,author,type));
  }
  public void displayBooks(){
    for(Book book: books){
      System.out.println(book.getName());
    }
  }
}