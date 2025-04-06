package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingObjectStreams {
  public static void main(String[] args) {
    mappingObjectStreams();
  }

  public static void mappingObjectStreams() {
    Stream.of("ash", "beach", "sycamore").map(String::toUpperCase).forEach(System.out::println);

    DoubleStream dblStream = Stream.of("ash", "beach", "sycamore").mapToDouble(String::length);
    dblStream.forEach(System.out::println);

    IntStream intStream = Stream.of("ash", "beach", "sycamore").mapToInt(String::length);
    intStream.forEach(System.out::println);

    LongStream longStream = Stream.of("ash", "beach", "sycamore").mapToLong(String::length);
    longStream.forEach(System.out::println);
  }
}
