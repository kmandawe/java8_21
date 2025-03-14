package lambdas;

import java.util.function.Predicate;

public class TestPredicate {

  public static void main(String[] args) {
    // Custom class
    Evaluate<Integer> lambda = i -> i < 0;
    System.out.println("Evaluate: " + lambda.isNegative(-1));
    System.out.println("Evaluate: " + lambda.isNegative(+1));

    // Java 8 built-in
    Predicate<Integer> predicate = i -> i < 0;
    System.out.println("Predicate: " + predicate.test(-1));
    System.out.println("Predicate: " + predicate.test(+1));
  }
}
