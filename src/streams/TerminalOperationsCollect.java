package streams;

import java.util.stream.Stream;

public class TerminalOperationsCollect {
  public static void main(String[] args) {
    StringBuilder word = Stream.of("ad", "jud", "i", "cate")
        .collect(() -> new StringBuilder(),
            (sb, str) -> sb.append(str),
            (sb1, sb2) -> sb1.append(sb2));
    System.out.println(word);


}
}
