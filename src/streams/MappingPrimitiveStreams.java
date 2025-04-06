package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingPrimitiveStreams {
  public static void main(String[] args) {
    mappingPrimitiveStream();
  }

  public static void mappingPrimitiveStream() {
    Stream<String> streamAges = IntStream.of(1, 2, 3).mapToObj(n -> "Number:" + n);
    streamAges.forEach(System.out::println);

    DoubleStream dblStream = IntStream.of(1, 2, 3).mapToDouble(n -> (double) n);
    dblStream.forEach(System.out::println);

    IntStream.of(1, 2, 3).map(n -> n * 2).forEach(System.out::println);

    IntStream.of(1, 2, 3).mapToLong(n -> (long) n).forEach(System.out::println);
  }
}
