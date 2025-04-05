package streams;

import java.util.stream.Stream;

public class IntermediateOperationsMap {
  public static void main(String[] args) {
    Stream.of("book", "pen", "ruler").map(s -> s.length()).forEach(System.out::println);
  }
}
