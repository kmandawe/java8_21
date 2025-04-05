package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsFlatMap {
  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("sean", "desmond");
    List<String> list2 = Arrays.asList("marry", "ann");
    Stream<List<String>> streamOfLists = Stream.of(list1, list2);
    streamOfLists.flatMap(list -> list.stream()).forEach(System.out::println);
  }
}
