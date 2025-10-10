package concurrency;

public class FixRaceWithSynchronized {
  private static final Object lock = new Object();
  private static int count = 0;

  //  public synchronized static void addToCounter() {
//  public static void addToCounter() {
//    synchronized (FixRaceWithSynchronized.class) {
  public synchronized void addToCounter() {
//    synchronized (this) {
      int c = count;
      System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getId());
      count = c + 1; // not atomic
      System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getId());
//    }
  }

  public static void main(String[] args) {
    FixRaceWithSynchronized instance = new FixRaceWithSynchronized();
    for (int i = 1; i <= 10; i++) {
      new Thread(instance::addToCounter).start();
    }
  }
}
