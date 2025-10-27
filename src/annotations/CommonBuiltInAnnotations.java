package annotations;

@FunctionalInterface
interface Movable {
  void move();
//  void run();
  boolean equals(Object o); // Object methods are not counted
}

class Person implements Movable {
  private String name;

  Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{name='" + name + "'}";
  }

  @Override
  public void move() {
    System.out.println(name + " is moving");
  }
}

public class CommonBuiltInAnnotations {
  public static void main(String[] args){
    Person sk = new Person("Sean Kennedy");
    System.out.println(sk);
    sk.move();
  }
}
