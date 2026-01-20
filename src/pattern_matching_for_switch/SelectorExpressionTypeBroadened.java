package pattern_matching_for_switch;

record R () {}
enum E {ONE}

public class SelectorExpressionTypeBroadened {
  public static void main(String[] args) {
    selectorType("abc");
    selectorType(new R());
    selectorType(E.ONE);
    selectorType(null);
    selectorType(new double[] {2.1, 3.5});
    selectorType(2);
  }

  public static void selectorType(Object obj) {
    System.out.println(
        switch (obj) {
          case String s -> "String";
          case R r -> "Record";
          case E e -> "Enum";
          case null -> "Null";
          case double[] da -> "double array";
          default -> "others";
        }
    );
  }
}
