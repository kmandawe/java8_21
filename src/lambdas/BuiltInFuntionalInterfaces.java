package lambdas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.crypto.spec.PSource;

public class BuiltInFuntionalInterfaces {
  public static void main(String[] args) {
    BuiltInFuntionalInterfaces fiApi = new BuiltInFuntionalInterfaces();
    fiApi.predicate();
    fiApi.supplier();
    fiApi.consumer();
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

  public void consumer() {
    Consumer<String> printC = s -> System.out.println(s);
    printC.accept("To be or not to be, that is the question.");

    List<String> names = new ArrayList<>();
    names.add("John");
    names.add("Mary");
    names.forEach(printC);

    var mapCapitalCities = new HashMap<String, String>();

    BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
    biCon.accept("Dublin", "Ireland");
    biCon.accept("Washington, D.C.", "USA");
    System.out.println(mapCapitalCities);

    BiConsumer<String, String> mapPrint =
        (key, value) -> System.out.println(key + " is the capital of : " + value);

    mapCapitalCities.forEach(mapPrint);
  }
}
