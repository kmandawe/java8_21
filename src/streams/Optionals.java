package streams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Optionals {
  public static void main(String[] args) {

    Optional<Double> optAvg = calcAverage(50, 60, 70);
    if (optAvg.isPresent()) {
      System.out.println(optAvg.get());
    }
    optAvg.ifPresent(System.out::println);
    System.out.println(optAvg.orElse(Double.NaN));

    System.out.println("========= EMPTY OPTIONAL ========");

    Optional<Double> optAvg2 = calcAverage();
    System.out.println(optAvg2.orElse(Double.NaN));
    System.out.println(optAvg2.orElseGet(() -> Math.random()));

    System.out.println("========= DEAL WITH null ========");
    doOptionalNull();

    System.out.println("========= OPTIONAL PRIMITIVE ========");
    doOptionalPrimitiveAverage();
  }

  public static Optional<Double> calcAverage(int... scores) {
    if (scores.length == 0) return Optional.empty();
    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return Optional.of((double) sum / scores.length);
  }

  public static void doOptionalNull() {
    Optional<String> optSK = howToDealWithNull("SK");
    optSK.ifPresent(System.out::println);

    Optional<String> optNull = howToDealWithNull(null);
    System.out.println(optNull.orElseGet(() -> "Empty optional"));
  }

  public static void doOptionalPrimitiveAverage() {
    OptionalDouble optAvg = IntStream.rangeClosed(1, 10).average();
    optAvg.ifPresent((d) -> System.out.println(d));
    System.out.println(optAvg.getAsDouble());
    System.out.println(optAvg.orElseGet(() -> Double.NaN));
  }

  private static Optional<String> howToDealWithNull(String param) {
    Optional optReturn = Optional.ofNullable(param);
    return optReturn;
  }
}
