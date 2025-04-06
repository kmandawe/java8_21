package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
  public static void main(String[] args) {
    Stream<String> animalsStream = List.of("sheep", "pigs", "horses").parallelStream();
    Stream<String> animalsStream2 = Stream.of("sheep", "pigs", "horses").parallel();

    int sum = Stream.of(10, 20, 30, 40, 50, 60).parallel().mapToInt(n -> n.intValue()).sum();
    System.out.println("Sum == " + sum);

    System.out.println("======== WATCH OUT FOR ORDERING ======= ");
    sequentialStream();
    parallelStream();
  }

  public static void sequentialStream() {
    Arrays.asList("a", "b", "c").stream().forEach(System.out::println);
  }

  public static void parallelStream() {
    Arrays.asList("a", "b", "c").stream().parallel().forEach(System.out::println);
  }
}
