package switch_expressions;

public class PatternMatching {
  public static void whatType(Object o) {
    switch (o) {
      case String s -> System.out.println("It's a string of length " + s.length());
      case Integer i -> System.out.println("It's an integer with value " + i);
      case null -> System.out.println("Null");
      default -> System.out.println("Unknown type");
    }
  }

  public static void infoOnType(Object o) {
    switch (o) {
      case String s when s.startsWith("A") -> System.out.println("String beginning with A: " + s);
      case Integer i when i > 10 -> System.out.println("Integer > 10 : " + i);
      case null -> System.out.println("Null");
      default -> System.out.println("Unknown type");
    }
  }

  public static void main(String[] args) {
    whatType("ABC");
    whatType(122);
    whatType(null);
    whatType(32.39);

    infoOnType("ABC");
    infoOnType("abc");
    infoOnType(12);
    infoOnType(8);
  }
}
