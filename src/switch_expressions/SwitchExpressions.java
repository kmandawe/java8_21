package switch_expressions;

enum Direction {
  NORTH, SOUTH, EAST, WEST
}

public class SwitchExpressions {
  public static void main(String[] args){
    Direction d = Direction.NORTH;

    // switch statement (fall-through => requires break)
    int numLetters = 0;
    switch (d) {
      case NORTH:
      case SOUTH:
        numLetters = 5;
        break;
      case EAST:
      case WEST:
        numLetters = 4;
        break;
    }
    System.out.println(numLetters);

    // switch expression came in Java 14:
    System.out.println(
        switch (d) {
//          case NORTH, SOUTH -> 5;
//          default ->  4;
          case NORTH, SOUTH: yield  5; // yield came in Java 13
          default: yield 4;
        }
    );
  }

}
