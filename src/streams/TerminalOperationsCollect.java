package streams;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsCollect {
  public static void main(String[] args) {
    StringBuilder word =
        Stream.of("ad", "jud", "i", "cate")
            .collect(
                () -> new StringBuilder(),
                (sb, str) -> sb.append(str),
                (sb1, sb2) -> sb1.append(sb2));
    System.out.println(word);

    String s = Stream.of("cake", "biscuits", "apple tart").collect(Collectors.joining(", "));
    System.out.println(s);

    Double avg =
        Stream.of("cake", "biscuits", "apple tart")
            .collect(Collectors.averagingInt(str -> str.length()));
    System.out.println(avg);

    Map<String, Integer> map =
        Stream.of("cake", "biscuits", "apple tart")
            .collect(Collectors.toMap(mapStr -> mapStr, mapStr -> mapStr.length()));
    System.out.println(map);

    Map<Integer, String> map2 =
        Stream.of("cake", "biscuits", "tart")
            .collect(
                Collectors.toMap(
                    map2Str -> map2Str.length(), map2Str -> map2Str, (s1, s2) -> s1 + "," + s2));
    System.out.println(map2);

    TreeMap<String, Integer> map3 =
        Stream.of("cake", "biscuits", "apple tart", "cake")
            .collect(
                Collectors.toMap(
                    map3Str -> map3Str,
                    map3Str -> map3Str.length(),
                    (len1, len2) -> len1 + len2,
                    () -> new TreeMap<>()));

    System.out.println(map3);
    System.out.println(map3.getClass());
  }
}
