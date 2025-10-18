package privateinterface;

// Why 'private' interface methods?
//  1. Reduce code duplication
//  2. Improves encapsulation by hiding implementation details
interface InefficientTennis {
  static void forehand() {
    System.out.println("Move into position");
    System.out.println("Hitting a forehand");
    System.out.println("Move back into ready position");
  }

  default void backhand() {
    System.out.println("Move into position");
    System.out.println("Hitting a backhand");
    System.out.println("Move back into ready position");
  }

  default void smash() {
    System.out.println("Move into position");
    System.out.println("Hitting a smash");
    System.out.println("Move back into ready position");
  }
}

interface Tennis {
  private static void hit(String stroke) {
    System.out.println("Move into position");
    System.out.println("Hitting a " + stroke);
    System.out.println("Move back into ready position");
  }
  static void forehand() { hit("forehand"); }
  default void backhand() { hit("backhand"); }
  private void smash() { hit("smash"); }
//  void volley() {hit("volley");}  // not allowed to have a body for abstract methods
}

class ProfessionalTennis implements Tennis {}

public class PrivateInterfaceMethods {

  public static void main(String[] args){
    Tennis tennis = new ProfessionalTennis();
//    tennis.hit(); // encapsulated, can't access
    tennis.backhand();
    Tennis.forehand();
  }
}
