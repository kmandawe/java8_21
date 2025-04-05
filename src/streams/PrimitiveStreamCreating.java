package streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamCreating {
  public static void main(String[] args){
    int[] ia = {1,2,3};
    double[] da = {1.1,2.2,3.3};
    long[] la = {1L,2L,3L};

    IntStream iStream1 = Arrays.stream(ia);
    DoubleStream dStream1 = Arrays.stream(da);
    LongStream lStream1 = Arrays.stream(la);
    System.out.println(iStream1.count() + ", " + dStream1.count() + ", " + lStream1.count());

    Stream<Integer> numbers = Stream.of(1, 2, 3);
    System.out.println(numbers.reduce(0, (a, b) -> a + b));

    IntStream intS = Stream.of(1,2,3)
        .mapToInt(i -> i);
    int total = intS.sum();
    System.out.println(total);
  }
}
