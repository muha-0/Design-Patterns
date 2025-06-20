import java.util.*;



public class Main {
    public static void main(String[] args) {
      
       Tree<Integar> tree = new Tree<Integar>(new Integar(1));
       tree.setLeft(new Tree<Integar>(new Integar(2)));
       tree.setRight(new Tree<Integar>(new Integar(3)));
       tree.left.setLeft(new Tree<Integar>(new Integar(4)));
       tree.left.setRight(new Tree<Integar>(new Integar(5)));
       Iterator<Integar> BFSiterator = tree.createBFSIterator();
       Iterator<Integar> DFSiterator = tree.createDFSIterator();
       while(BFSiterator.hasNext()){
         Integar x = BFSiterator.getNext();
         System.out.println(x.getValue());
       }
       System.out.println("-----");
       while(DFSiterator.hasNext()){
         Integar x = DFSiterator.getNext();
         System.out.println(x.getValue());
       }
    }
}

class Integar{
  int val;
  Integar(int val){
    this.val = val;
  }
  int getValue(){
    return val;
  }
}

interface Iterator<T>{
  public boolean hasNext();
  public T getNext();
  public void reset();
}

class BFS<T> implements Iterator<T>{
  private Tree<T> tree;
  private ArrayList<Tree<T>> queue = new ArrayList<>();
  public BFS(Tree<T> tree){
    this.tree = tree;
    queue.add(tree);
  }
  public boolean hasNext(){
    return !(queue.isEmpty());
  }
  public T getNext(){
    Tree<T> current_tree = queue.remove(0);
    if(current_tree.left != null){
      queue.add(current_tree.left);
    }
    if(current_tree.right != null){
      queue.add(current_tree.right);
    }
    return current_tree.value;
  }
  public void reset(){
    queue.clear();
    queue.add(tree);
  }
}

class DFS<T> implements Iterator<T>{
  private Tree<T> tree;
  private ArrayList<Tree<T>> stack = new ArrayList<>();
  public DFS(Tree<T> tree){
    this.tree = tree;
    stack.add(tree);
  }
  public boolean hasNext(){
    return !(stack.isEmpty());
  }
  public T getNext(){
    Tree<T> current_tree = stack.remove(stack.size()-1);
    if(current_tree.right!=null){
      stack.add(current_tree.right);
    }
    if(current_tree.left!=null){
      stack.add(current_tree.left);
    }
    return current_tree.value;
  }
  public void reset(){
    stack.clear();
    stack.add(tree);
  }
}

class Tree<T> {
    //All public for simplicity but you should use setters/getters
    public T value;
    public Tree<T> left;
    public Tree<T> right;

    public Tree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Iterator<T> createBFSIterator(){
      return new BFS<T>(this);
    }
    public Iterator<T> createDFSIterator(){
      return new DFS<T>(this);
    }
    // Setters
    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }

    // Getters
    public Tree<T> getLeft() {
        return left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

}
