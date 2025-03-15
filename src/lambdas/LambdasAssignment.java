package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAssignment {

  public static void main(String[] args) {
    consumer();
    supplier();
    predicate();
    function();
    var listPeople = getPeople();
    System.out.println("Sort age:");
    sortAge(listPeople);
    System.out.println("Sort name:");
    sortName(listPeople);
    System.out.println("Sort height:");
    sortHeight(listPeople);
  }

  public static <T> boolean check(T t, Predicate<T> predicate) {
    return predicate.test(t);
  }

  public static void consumer() {
    Printable<String> printable = s -> System.out.println(s);
    printable.print("Printable lambda");

    Consumer<String> lConsumer = s -> System.out.println(s);
    Consumer<String> mrConsumer = System.out::println;

    lConsumer.accept("Printable lambda");
    mrConsumer.accept("Printable lambda");
  }

  public static void supplier() {
    Retrievable<Integer> retrievable = () -> 77;
    Supplier<Integer> supplier = () -> 77;
    System.out.println(retrievable.retrieve());
    System.out.println(supplier.get());
  }

  private static void predicate() {

    Evaluate<Integer> evaluate = i -> i < 0;
    System.out.println(evaluate.isNegative(-1));
    System.out.println(evaluate.isNegative(+1));

    Predicate<Integer> predicate = i -> i < 0;
    System.out.println(predicate.test(-1));
    System.out.println(predicate.test(+1));

    System.out.println(check(4, i -> i % 2 == 0));
    System.out.println(check(7, i -> i % 2 == 0));

    System.out.println(check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));
    System.out.println(check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));

    Person mike = new Person("Mike", 33, 1.8);
    Person ann = new Person("Ann", 13, 1.4);

    System.out.println(check(mike, p -> p.getAge() >= 18));
    System.out.println(check(ann, p -> p.getAge() >= 18));
  }

  private static void function() {
    Functionable<Integer, String> functionable = i -> "Number is: " + i;
    System.out.println(functionable.apply(25));

    Function<Integer, String> function = i -> "Number is: " + i;
    System.out.println(function.apply(25));
  }

  private static void sortAge(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(p1 -> p1.getAge()));
    listPeople.forEach(p -> System.out.println(p));
    System.out.println("Refactor:");
    listPeople.forEach(System.out::println);
  }

  private static void sortName(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(p1 -> p1.getName()));
    listPeople.forEach(p -> System.out.println(p));
    System.out.println("Refactor:");
    listPeople.forEach(System.out::println);
  }

  private static void sortHeight(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(p1 -> p1.getHeight()));
    listPeople.forEach(p -> System.out.println(p));
    System.out.println("Refactor:");
    listPeople.forEach(System.out::println);
  }

  private static List<Person> getPeople() {

    List<Person> result = new ArrayList<>();

    result.add(new Person("Mike", 33, 1.8));

    result.add(new Person("Mary", 25, 1.4));

    result.add(new Person("Alan", 34, 1.7));

    result.add(new Person("Zoe", 30, 1.5));

    return result;
  }
}
