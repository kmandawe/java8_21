package collections_generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Dog3 {
  private String name;

  Dog3(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Dog3 dog = (Dog3) o;
    return Objects.equals(name, dog.name);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    // simple algorithm
    hash = 83 * hash + this.name.length();
    return hash;
  }
}

public class MutableFieldsTest {
  public static void main(String[] args) {
    // Dog has a hashCode() method
    Dog3 spot = new Dog3("Spot");
    Map<Dog3, String> dogs = new HashMap<>();

    dogs.put(spot, "Great Dane");
    System.out.println("spotInMap = " + spot.hashCode() + " in map? " + dogs.containsKey(spot));

    /**
     * API: "Note: great care must be exercised if mutable objects are used as map keys. The
     * behavior of a map is not specified if the value of the object is changed in a manner that
     * affects equals comparisons while the object is a key in the map
     */

    // change the object state (the dogs name); note that the dogs name is USED in
    // the calculation of the hash value (and is used in equals() also).
    spot.setName("Rex");

    // assuming we have overriden hashCode(), it is false as the object state has changed
    // i.e. the hash code is re-calculated and is going to be different because the name is
    // now different - this is dangerous!
    System.out.println("spotInMap = " + spot.hashCode() + " in map? " + dogs.containsKey(spot));
  }
}
