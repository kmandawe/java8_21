package streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsPartitioningBy {
  public static void main(String[] args) {
    Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
    Map<Boolean, List<String>> map =
        names.collect(Collectors.partitioningBy(s -> s.startsWith("T")));
    System.out.println(map);

    Stream<String> names2 = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");
    Map<Boolean, Set<String>> map2 =
        names2.collect(Collectors.partitioningBy(s -> s.length() > 4, Collectors.toSet()));
    System.out.println(map2);

  }
}
