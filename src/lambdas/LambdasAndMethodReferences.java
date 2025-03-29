package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAndMethodReferences {
  public static void main(String[] args) {
    staticMr();
    boundMR();
    unboundMR();
    constructorMR();
  }

  static void staticMr() {
    List<Integer> intList = Arrays.asList(5, 2, 7, 4, 1);
    Consumer<List<Integer>> consumer = list -> Collections.sort(list);
    consumer.accept(intList);
    System.out.println(intList);
    List<Integer> intList2 = Arrays.asList(5, 2, 7, 4, 1);
    Consumer<List<Integer>> consumerMR = Collections::sort;
    consumerMR.accept(intList2);
    System.out.println(intList2);
  }

  static void boundMR() {
    String name = "Mr. Joe Bloggs";
    Predicate<String> predicate = s -> name.startsWith(s);
    System.out.println(predicate.test("Mr."));
    System.out.println(predicate.test("Ms."));
    Predicate<String> predicateMR = name::startsWith;
    System.out.println(predicateMR.test("Mr."));
    System.out.println(predicateMR.test("Ms."));
  }

  static void unboundMR() {
    Predicate<String> predicate = s -> s.isEmpty();
    System.out.println(predicate.test(""));
    System.out.println(predicate.test("xyz"));
    Predicate<String> predicateMR = String::isEmpty;
    System.out.println(predicateMR.test(""));
    System.out.println(predicateMR.test("xyz"));

    BiPredicate<String, String> biPredicate = (s1, s2) -> s1.startsWith(s2);
    System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mr."));
    System.out.println(biPredicate.test("Mr. Joe Bloggs", "Ms."));

    BiPredicate<String, String> biPredicateMR = String::startsWith;
    System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
    System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));
  }

  static void constructorMR() {
    Supplier<List<String>> supplier =  () -> new ArrayList<>();
    List<String> list = supplier.get();
    list.add("Lambda");
    System.out.println(list);

    Supplier<List<String>> supplierMR = ArrayList::new;
    List<String> listMR = supplier.get();
    listMR.add("Method Reference");
    System.out.println(listMR);

    Function<Integer, List<String>> function = i -> new ArrayList<>(i);
    List<String> funcList = function.apply(10);
    funcList.add("Lamda");
    System.out.println(funcList);

    Function<Integer, List<String>> functionMR = ArrayList::new;
    List<String> funcListMR = function.apply(10);
    funcListMR.add("Method Reference");
    System.out.println(funcList);
  }
}
