package streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsGroupingBy {
  public static void main(String[] args){
    Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
    Map<Integer, List<String>> map = names.collect(
        Collectors.groupingBy(String::length));
    System.out.println(map);

    Stream<String> names2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
    Map<Integer, Set<String>> map2 = names2.collect(
        Collectors.groupingBy(String::length, Collectors.toSet()));
    System.out.println(map2);

    Stream<String> names3 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
    TreeMap<Integer, List<String>> map3 =
        names3.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    System.out.println(map3);
    System.out.println(map3.getClass());
  }
}
