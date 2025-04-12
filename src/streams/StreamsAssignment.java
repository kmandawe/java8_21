package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsAssignment {
  public static void main(String[] args) {
    System.out.println("======= Int Primitive Average =========");
    intPrimitiveAverage();
    System.out.println("======= Sorting Items =========");
    sortingItems();
    System.out.println();
    System.out.println("======= Filter and FlatMap =========");
    filterAndFlatMap();
    System.out.println("======= Terminal Operators =========");
    usingTerminalOperators();
    System.out.println("======= Grade Optionals =========");
    Optional<String> grade1 = getGrade(50);
    Optional<String> grade2 = getGrade(55);
    System.out.println(grade1.orElse("UNKNOWN"));
    if (grade2.isPresent()) {
      grade2.ifPresent(System.out::println);
    } else {
      System.out.println(grade2.orElse("Empty"));
    }
    System.out.println("======= Map Books =========");
    mapBooks();
    System.out.println("======= Books Collect =========");
    booksCollect();
    System.out.println("======= Books Collect 2 =========");
    booksCollect2();
    System.out.println("======= Persons List Optional =========");
    personListOptional();
    System.out.println("======= More Optionals =========");
    moreOptionals();
    System.out.println("======= Genre List =========");
    genreList();
    System.out.println("======= Primitive Doubles =========");
    primitiveDoubles();
    System.out.println("======= Lazy Evaluation =========");
    lazyEvaluation();
    System.out.println("======= Parallel Stream 1 =========");
    parallelStream1();
    System.out.println("======= Parallel Stream 2 =========");
    parallelStream2();
  }

  public static void intPrimitiveAverage() {
    IntStream.range(0, 5).average().ifPresent(System.out::println);
  }

  public static void sortingItems() {
    Item item1 = new Item(1, "Screw");
    Item item2 = new Item(2, "Nail");
    Item item3 = new Item(3, "Bolt");

    Stream.of(item1, item2, item3)
        .sorted(Comparator.comparing(Item::getName))
        .forEach(System.out::print);
  }

  public static void filterAndFlatMap() {
    Stream<List<String>> listStream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
    listStream
        .filter(list -> list.contains("c"))
        .flatMap(Collection::stream)
        .forEach(System.out::println);
  }

  public static void usingTerminalOperators() {
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    int sum = numbers.stream().mapToInt(n -> n).sum();
    System.out.println("Sum of numbers: " + sum);
    int max = numbers.stream().mapToInt((Integer n) -> n).max().orElse(0);
    System.out.println("Max number: " + max);

    List<Person> persons =
        Arrays.asList(
            new Person("Alan", "Burke", 22),
            new Person("Zoe", "Peters", 20),
            new Person("Peter", "Castle", 29));
    persons.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

    List<Integer> intList = Arrays.asList(10, 47, 33, 23);
    intList.stream().reduce(Integer::sum).ifPresent(System.out::println);
    int intSum = intList.stream().reduce(0, Integer::sum);
    System.out.println(intSum);
  }

  public static Optional<String> getGrade(int marks) {
    Optional<String> grade;
    if (marks > 50) {
      grade = Optional.of("PASS");
    } else {
      grade = Optional.of("FAIL");
    }
    return grade;
  }

  public static void mapBooks() {
    Book book1 = new Book("Thinking in Java", 30.0);
    Book book2 = new Book("Java in 24 hrs", 20.0);
    Book book3 = new Book("Java recipes", 10.0);

    Stream.of(book1, book2, book3)
        .filter(book -> book.getPrice() > 10.0)
        .mapToDouble(Book::getPrice)
        .average()
        .ifPresent(System.out::println);
  }

  public static void booksCollect() {
    Book book1 = new Book("Atlas Shrugged", 10.0);
    Book book2 = new Book("Freedom at Midnight", 5.0);
    Book book3 = new Book("Gone with the wind", 5.0);

    Map<String, Double> bookMap =
        Stream.of(book1, book2, book3).collect(Collectors.toMap(Book::getTitle, Book::getPrice));
    bookMap.forEach(
        (k, v) -> {
          if (k.startsWith("A")) {
            System.out.println(v);
          }
        });
  }

  public static void booksCollect2() {
    Book book1 = new Book("Gone with the wind", 5.0);
    Book book2 = new Book("Gone with the wind", 10.0);
    Book book3 = new Book("Atlas Shrugged", 15.0);

    Stream.of(book1, book2, book3)
        .collect(Collectors.toMap(Book::getTitle, Book::getPrice, Double::max))
        .forEach((k, v) -> System.out.println(k + ": " + v));
  }

  public static void personListOptional() {
    Person person1 = new Person("Bob", 31);
    Person person2 = new Person("Paul", 32);
    Person person3 = new Person("John", 33);

    double average =
        Stream.of(person1, person2, person3)
            .filter(p -> p.getAge() < 30)
            .mapToInt(Person::getAge)
            .average()
            .orElse(0.0);
    System.out.println(average);
  }

  public static void moreOptionals() {
    Optional<Double> price = Optional.ofNullable(20.0);
    price.ifPresent(p -> System.out.println("Price is: " + p));
    System.out.println(price.orElse(Double.NaN));
    System.out.println(price.orElseGet(() -> Double.NaN));

    Optional<Double> price2 = Optional.ofNullable(null);
    System.out.println(price2);
    if (price2.isEmpty()) {
      System.out.println("empty");
    }
    price2.ifPresent(p -> System.out.println("Price is: " + p));
    Double x = price2.orElse(44.0);
    System.out.println(x);

    Optional<Double> price3 = Optional.ofNullable(null);
    //    Double z = price3.orElseThrow(() -> new RuntimeException("Bad code"));
  }

  public static void genreList() {
    Book book1 = new Book("Gone with the wind", "Fiction");
    Book book2 = new Book("Bourne Ultimatum", "Thriller");
    Book book3 = new Book("The Client", "Thriller");

    List<String> genreList = new ArrayList<>();
    Stream.of(book1, book2, book3).map(Book::getGenre).distinct().forEach(genreList::add);

    System.out.println(genreList);
  }

  public static void primitiveDoubles() {
    double sum = DoubleStream.of(0, 2, 4).filter(n -> n % 2 != 0).sum();
    System.out.println(sum);

    Stream.of(1.0, 3.0)
        .mapToDouble(n -> n)
        .filter(n -> n % 2 == 0)
        .average()
        .ifPresent(System.out::println);
  }

  public static void lazyEvaluation() {
    List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
    boolean anyMatch = ls.stream().distinct().anyMatch(n -> n == 11);
    System.out.println(anyMatch);

    boolean noneMatch = ls.stream().distinct().noneMatch(x -> x % 11 > 0);
    System.out.println(noneMatch);
  }

  public static void parallelStream1() {
    AtomicInteger ai = new AtomicInteger();
    Stream.of(11, 11, 22, 33)
        .parallel()
        .filter(n -> {
          ai.incrementAndGet();
          return n % 2 == 0;
        });
    System.out.println(ai);
  }

  public static void parallelStream2() {
    AtomicInteger ai = new AtomicInteger();
    Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
    stream.filter( e -> {
      ai.incrementAndGet();
      return e % 2 == 0;
    }).forEach(System.out::println);
    System.out.println(ai);
  }
}
