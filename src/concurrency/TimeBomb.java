package concurrency;

// sleep() and join()
class CountDown implements Runnable {
  String[] timeStr = {
    "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
  };

  @Override
  public void run() {
    for (int i = 9; i >= 0; i--) {
      try {
        System.out.println(timeStr[i]);
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class TimeBomb {
  public static void main(String[] args) {
    Thread timer = new Thread(new CountDown());
    System.out.println("Starting 10 seconds countdown...");
    timer.start();
    try {
      timer.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Boom!!!");
  }
}
