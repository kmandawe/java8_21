package pattern_matching_for_switch;

sealed interface Colour permits Primary, Rainbow {}

enum Primary implements Colour {
  RED,
  GREEN,
  BLUE
}

enum Rainbow implements Colour {
  RED,
  ORANGE,
  YELLOW,
  GREEN,
  BLUE,
  INDIGO,
  VIOLET
}

public class QualifiedEnumConstants {

  public static void switchColour(Colour colour) {
    switch (colour) {
      //      case Primary primary
      //      when primary == Primary.RED:
      //        System.out.println("Primary::Red");
      //        break;
      //      case Rainbow rainbow
      //      when rainbow == Rainbow.RED:
      //        System.out.println("Rainbow::Red");
      //        break;

      case Primary.RED:
        System.out.println("Primary.Red");
        break;
      case Rainbow.RED:
        System.out.println("Rainbow.Red");
        break;
      default:
        System.out.println("Other colour");
        break;
    }
  }

  public static void switchPrimary(Primary primary) {
    switch (primary) {
      case RED -> System.out.println("Primary::Red");
      case BLUE -> System.out.println("Primary::Blue");
    }
  }

  public static void switchRainbow(Rainbow rainbow) {
    switch (rainbow) {
      case RED -> System.out.println("Rainbow::Red");
      case BLUE -> System.out.println("Rainbow::Blue");
    }
  }

  static void main() {
    switchPrimary(Primary.RED);
    switchRainbow(Rainbow.RED);
    switchColour(Primary.RED);
  }
}
