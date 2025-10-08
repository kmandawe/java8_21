package collections_generics;

import java.util.Objects;

class Foo {
  private int fooValue;
  Foo(int fooValue) {
    this.fooValue = fooValue;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass())
      return false;
    Foo foo = (Foo) o;
    return fooValue == foo.fooValue;
  }

  @Override
  // NB: The contract requires only that two equal objects have equal hashcodes.
  public int hashCode() {
    return fooValue * 17; // using the same instance var as equals

    // the following implementation doe NOT violate the contract as two
    // equal objects will return the same hashcode 100. It is legal and
    // even correct but horribly inefficient as all objects (including unequal ones,
    // land on the same bucket). This implementation does not improve
    // the search time which is what hashcodes are supposed to do.
    // public int hashCode() { return 100; }
  }

}
public class EqualsTest {
  public static void main(String[] args){
    Foo f1 = new Foo(2);
    Foo f2 = new Foo(2);
    System.out.println(f1.equals(f2));  // true
    System.out.println(f1.equals("SK")); // false (no ClassCastException)

    Foo f3 = new Foo(3);
    System.out.println(f1.hashCode());
    System.out.println(f2.hashCode());
    System.out.println(f3.hashCode());
  }
}
