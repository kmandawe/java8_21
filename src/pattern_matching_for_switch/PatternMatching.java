package pattern_matching_for_switch;

public class PatternMatching {

  public static void whatType(Object o) {
    switch (o) {  // switch statement does not cover all possible input values
      case String s -> System.out.println("String");
      case Integer i -> System.out.println("Integer");
      case null -> System.out.println("Null");
      default -> System.out.println("Not recognized");
    }
    System.out.println(
        switch (o) {  // switch expression does not cover all possible input values
          case String s -> "String";
          case Integer i -> "Integer";
          case null -> "Null";
          default -> "Not recognized";
        }
    );
  }
  public static void infoOnType(Object o) {
    switch (o) {
      case String s when s.startsWith("A") -> System.out.println("String beginning with A: " + s);
      case Integer i when i.intValue() > 10 -> System.out.println("Integer > 10: " + i);
      case null -> System.out.println("Null");
      default -> System.out.println("Not recognized");
    }
  }

  public static void exceptionInTest() {

  }

  static void main(){
//    whatType("ABC");
//    whatType(122);
//    whatType(null);
//    whatType(32.39);

    infoOnType("ABC");
    infoOnType("a");
    infoOnType(12);
    infoOnType(8);
    infoOnType(null);


  }
}
