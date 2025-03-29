package streams;

import java.util.stream.Stream;

public class InfiniteStreams {
  public static void main(String[] args){
    Stream<Integer> infStream = Stream.generate(() -> (int) (Math.random() * 10));
//    infStream.forEach(System.out::println);

    Stream<Integer> infStream2 = Stream.iterate(2, n -> n + 2).limit(10);
    infStream2.forEach(System.out::println);


  }
}
