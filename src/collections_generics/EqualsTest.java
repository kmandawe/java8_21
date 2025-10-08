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

}
public class EqualsTest {
  public static void main(String[] args){
    Foo f1 = new Foo(2);
    Foo f2 = new Foo(2);
    System.out.println(f1.equals(f2));  // true
    System.out.println(f1.equals("SK")); // false (no ClassCastException)
  }
}
