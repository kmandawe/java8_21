package streams;

import java.util.stream.Stream;

public class IntermediateOperationsFilter {
  public static void main(String[] args){
    Stream.of("galway", "mayo", "roscommon")
        .filter(countyName -> countyName.length() > 5)
        .forEach(System.out::println);
  }
}
