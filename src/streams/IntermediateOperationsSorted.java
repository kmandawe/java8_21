package streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateOperationsSorted {
  public static void main(String[] args){
    Person john = new Person("John", 23);
    Person mary = new Person("Mary", 25);

    Stream.of(mary, john)
        .sorted(Comparator.comparing(Person::getAge))
        .forEach(System.out::println);

    Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
        .peek(name -> System.out.println(" 0." + name))
        .filter(name -> name.length() == 3)
        .peek(name -> System.out.println(" 1." + name))
        .sorted()
        .peek(name -> System.out.println(" 2." + name))
        .limit(2)
        .forEach(name -> System.out.println(" 3." + name));
  }
}
