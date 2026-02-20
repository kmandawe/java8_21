package j25.stream_gatherers;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class BuiltInGatherersDemo {
  static void main() {
    // CHUNKS (fixed windows) - no overlap, the last one may be shorter
    var fixed = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).gather(Gatherers.windowFixed(3)).toList();
    IO.println("windowFixed(3) => " + fixed);

    // SLIDING WINDOWS - overlapping
    var sliding = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).gather(Gatherers.windowSliding(3)).toList();
    IO.println("windowSliding(3) => " + sliding);

    // RUNNING TOTALS - emits one result per input element
    var runningTotals = Stream.of(1, 2, 3, 4, 5).gather(Gatherers.scan(() -> 0, Integer::sum)).toList();
    IO.println("scan(sum) => " + runningTotals);
  }
}
