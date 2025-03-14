package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Sean", "Mary", "John");
    names.forEach(name -> System.out.println(name));
    names.forEach(System.out::println);
    boundMethodReferences();
  }

  public static void boundMethodReferences() {
    String name = "Mr. Joe Bloggs";

    Supplier<String> lowerL = () -> name.toLowerCase();
    Supplier<String> lowerMR = name::toLowerCase;

    System.out.println(lowerL.get());
    System.out.println(lowerMR.get());

    Predicate<String> titleR = title -> name.startsWith(title);
    Predicate<String> titleMR = name::startsWith;

    System.out.println(titleR.test("Mr."));
    System.out.println(titleMR.test("Ms."));
  }
}
