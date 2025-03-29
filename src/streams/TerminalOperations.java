package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {
  public static void main(String[] args) {
    long count = Stream.of("dog", "cat").count();
    System.out.println(count);

    Optional<String> min =
        Stream.of("dear", "horse", "pig")
            .min(
                (s1, s2) -> {
                  return s1.length() - s2.length();
                });
    min.ifPresent(System.out::println);

    Optional<Integer> max = Stream.of(4,6,2, 12, 9)
        .max((i1, i2) -> i1 - i2 );
    max.ifPresent(System.out::println);

    Optional<String> any = Stream.of("John", "Paul").findAny();
    any.ifPresent(System.out::println);

    Optional<String> first = Stream.of("John", "Paul").findFirst();
    first.ifPresent(System.out::println);

    List<String> names = Arrays.asList("Alan", "Brian", "Colin");
    Predicate<String> pred = name -> name.startsWith("A");
    System.out.println(names.stream().anyMatch(pred));
    System.out.println(names.stream().allMatch(pred));
    System.out.println(names.stream().noneMatch(pred));

    Stream<String> names2 = Stream.of("Cathy", "Pauline", "Zoe");
    names2.forEach(System.out::println);

    Stream<Integer> s = Stream.of(1);


  }
}
