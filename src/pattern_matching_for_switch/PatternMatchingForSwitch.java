package pattern_matching_for_switch;

sealed class Vehicle permits Car, Boat, Train {}
final class Car extends Vehicle {
  private int numDoors;
  Car(int numDoors) {this.numDoors = numDoors;}
  public int getNumDoors() {return numDoors;}
  public String onRoad() {return "I can move on the road";}
}
final class Boat extends Vehicle {}
final class Train extends Vehicle {}


public class PatternMatchingForSwitch {
  public static void patternMatchingSwitch(Vehicle v) {
    System.out.println(
        switch (v) {
          case Boat b -> "It's a boat";
          case Train t -> "It's a train";
          case Car c when c.getNumDoors() == 4 -> "It's a Saloon/Sedan: " + c.onRoad();
          case Car c when c.getNumDoors() == 2 -> {
            yield "It's a Convertible: " + c.onRoad();
          }
          case null, default -> "Invalid type";
//          case Vehicle vehicle -> "Generic vehicle";
//          default -> "It's a car";
        }
    );
  }

  static void main(){
    patternMatchingSwitch(new Car(2));
    patternMatchingSwitch(new Car(4));
    patternMatchingSwitch(new Boat());
    patternMatchingSwitch(new Train());
    patternMatchingSwitch(new Vehicle());
    patternMatchingSwitch(null);
  }
}
