package virtual_threads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadComparison {
  static void main(){
    final int NUM_TASKS = 10_000_000, BLOCKING_CALL = 1;
    System.out.println("Starting comparison with " + NUM_TASKS + " tasks each.");

    long startTime = System.currentTimeMillis();

    // OutOfMemoryError, tries to create a platform thread for each task
//    try (var executor = Executors.newCachedThreadPool()) {

      // 200 platform threads for NUM_TASKS tasks e.g. 10_000
//      try (var executor = Executors.newFixedThreadPool(200)) {  // 100 platform threads

        // NUM_TASKS virtual threads
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      IntStream.range(0, NUM_TASKS).forEach(i -> {
        executor.submit(() -> {
          Thread.sleep(Duration.ofSeconds(BLOCKING_CALL));
          return i;
        });
      });
    } // executor.close() is called implicitly, will only close after all tasks are finished

    long endTime = System.currentTimeMillis();
    System.out.println("Duration: " + (endTime - startTime) + " ms");
  }
}
