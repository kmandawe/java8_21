package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {
  public static void main(String[] args) {
    // create an ExecutorService with a fixed thread pool consisting of one thread
    ExecutorService es = Executors.newSingleThreadExecutor();

    // submit the callable task (asynchronously) to the executor service
    Future<Integer> future = es.submit(() -> 3 + 5); // V call()

    try {
      // get() will block for 500 msecs max.
      // TimeUnit is an enum
      System.out.println("The answer is: " + future.get(500, TimeUnit.MILLISECONDS));
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    }

    // shutdown the executor service otherwise this application will never terminate;
    // existing tasks will be allowed to complete but no new tasks accepted
    es.shutdown();
  }
}
