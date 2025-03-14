package lambdas;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Sean", "Mary", "John");
    names.forEach(name -> System.out.println(name));
    names.forEach(System.out::println);
  }
}
