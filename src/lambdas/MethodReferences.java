package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Sean", "Mary", "John");
    names.forEach(name -> System.out.println(name));
    names.forEach(System.out::println);
    boundMethodReferences();
    unboundMethodReferences();
    staticMethodReferences();
    constructorMethodReferences();
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

  public static void unboundMethodReferences() {
    Function<String,String> upperL = s -> s.toUpperCase();
    Function<String,String> upperMR = String::toUpperCase;

    System.out.println(upperL.apply("sean"));
    System.out.println(upperMR.apply("sean"));

    BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
    BiFunction<String, String, String> concatMR = String::concat;
    System.out.println(concatL.apply("Sean", "Kennedy"));

    System.out.println(concatMR.apply("Sean", "Kennedy"));
  }

  public static void staticMethodReferences() {
    Consumer<List<Integer>> sortL = list -> Collections.sort(list);
    Consumer<List<Integer>> sortMR = Collections::sort;

    List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
    sortL.accept(listOfNumbers);
    System.out.println(listOfNumbers);

    listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
    sortMR.accept(listOfNumbers);
    System.out.println(listOfNumbers);
  }

  public static void constructorMethodReferences() {
    Supplier<StringBuilder> sbL = () -> new StringBuilder();
    Supplier<StringBuilder> sbMR = StringBuilder::new;

    StringBuilder sb1 = sbL.get(); sb1.append("lambda version");
    System.out.println(sb1);

    StringBuilder sb2 = sbMR.get(); sb2.append("method reference version");
    System.out.println(sb2);

    Function<Integer, List<String>> alL = x -> new ArrayList<>(x);
    Function<Integer, List<String>> alMR = ArrayList::new;

    List<String> ls1 = alL.apply(10);
    ls1.add("21");
    System.out.println(ls1);
    List<String> ls2 = alMR.apply(5);
    ls2.add("88");
    System.out.println(ls2);
  }
}
