package streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamsApi {
  public static void main(String[] args) {
    OptionalInt max = IntStream.of(10, 20, 30).max();
    max.ifPresent(System.out::println);

    OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0).min();
    System.out.println(min.orElseThrow());

    OptionalDouble average = LongStream.of(10L, 20L, 30L).average();
    System.out.println(average.orElseGet(() -> Math.random()));

    System.out.println("========== STATS ============");
    stats(IntStream.of(5, 10, 15, 20));
    System.out.println("========== STATS ============");
    stats(IntStream.empty());
  }

  static void stats(IntStream numbers) {
    IntSummaryStatistics stats = numbers.summaryStatistics();
    int min = stats.getMin();
    System.out.println(min);
    int max = stats.getMax();
    System.out.println(max);
    double avg = stats.getAverage();
    System.out.println(avg);
    long count = stats.getCount();
    System.out.println(count);
    long sum = stats.getSum();
    System.out.println(sum);
  }
}
