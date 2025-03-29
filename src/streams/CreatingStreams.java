package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CreatingStreams {
  public static void main(String[] args) {
    Double[] numbers = {1.1, 2.2, 3.3};
    Stream<Double> stream1 = Arrays.stream(numbers);
    long n = stream1.count();
    System.out.println("Number of elements: " + n);

    List<String> animalList = Arrays.asList("cat", "dog", "sheep");
    Stream<String> streamAnimals = animalList.stream();
    System.out.println("Number of elements: " + streamAnimals.count());

    Map<String, Integer> namesToAges = new HashMap<>();
    namesToAges.put("Mike", 22);
    namesToAges.put("Mary", 24);
    namesToAges.put("Alice", 31);
    System.out.println("Number of entries: " + namesToAges.entrySet().stream().count());

    Stream<Integer> streamInt = Stream.of(1, 2, 3);
    System.out.println(streamInt.count());

    Stream<String> streamS = Stream.of("a", "b", "c", "d");
    System.out.println(streamS.count());

    Stream<Dog> streamD = Stream.of(new Dog());
    System.out.println(streamD.count());
  }
}
