package lambdas;

import java.time.LocalTime;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFuntionalInterfaces {
  public static void main(String[] args) {
    BuiltInFuntionalInterfaces fiApi = new BuiltInFuntionalInterfaces();
    fiApi.predicate();
    fiApi.supplier();
  }

  public void predicate() {
    Predicate<String> pStr = s -> s.contains("City");
    System.out.println(pStr.test("Vatican City"));

    BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
    System.out.println(checkLength.test("Vatican City", 8));
  }

  public void supplier() {
    Supplier<StringBuilder> supSb = () -> new StringBuilder();
    System.out.println("Supplier SB: " + supSb.get().append("SK"));

    Supplier<LocalTime> supTime = () -> LocalTime.now();
    System.out.println("Supplier time: " + supTime.get());

    Supplier<Double> sRandom = () -> Math.random();
    System.out.println(sRandom.get());
  }
}
