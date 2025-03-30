package streams;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TerminalOperationsReduce {
  public static void main(String[] args) {
    String name = Stream.of("s", "e", "a", "n").reduce("", (x, y) -> x + y);
    System.out.println(name);

    Integer product = Stream.of(2, 3, 4).reduce(1, (x, y) -> x * y);
    System.out.println(product);

    BinaryOperator<Integer> op = (a, b) -> a + b;
    Stream<Integer> empty = Stream.empty();
    Stream<Integer> oneElement = Stream.of(6);
    Stream<Integer> multipleElements = Stream.of(3, 4, 5);
    System.out.println("==============");
    empty.reduce(op).ifPresent(System.out::println);
    oneElement.reduce(op).ifPresent(System.out::println);
    multipleElements.reduce(op).ifPresent(System.out::println);

    System.out.println("==============");
    Integer val = Stream.of(1, 1, 1).reduce(1, (a, b) -> a);
    System.out.println(val);

    Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
    int length = stream.reduce(0, (n, str) -> n + str.length(), (n1, n2) -> n1 + n2);
    System.out.println(length);
  }
}
