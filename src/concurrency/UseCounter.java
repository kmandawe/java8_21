package concurrency;

public class UseCounter {
  private int x;

  public void incrementA() {
    synchronized (this) {
      x++;
    }
  }

  public synchronized void incrementB() {
    x++;
  }

  private static int y;
  public static void decrementA() {
    // static blocks lock on the clas object
    // Every class is associated with an object of Class type
    // accessible using Classname.class
    synchronized (UseCounter.class) {
      y--;
    }
  }

  // static methods locks on the class object
  public static synchronized void decrementB() {
    y--;
  }
}
