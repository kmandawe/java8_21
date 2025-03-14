package lambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BuiltInFuntionalInterfaces {
  public static void main(String[] args){
    BuiltInFuntionalInterfaces fiApi = new BuiltInFuntionalInterfaces();
    fiApi.predicate();
  }

  public void predicate() {
    Predicate<String> pStr = s -> s.contains("City");
    System.out.println(pStr.test("Vatican City"));

    BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
    System.out.println(checkLength.test("Vatican City", 8));
  }
}
