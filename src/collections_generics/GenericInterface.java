package collections_generics;

interface Moveable<T> {
  void move(T t);
}

class MoveFeline implements Moveable<Cat> {
  @Override
  public void move(Cat cat) {
    System.out.println("Feline moving");
  }
}

class MoveCanine implements Moveable<Dog> {
  @Override
  public void move(Dog dog) {
    System.out.println("Canine moving");
  }
}

class SomeMoveable<U> implements Moveable<U> {
  @Override
  public void move(U u) {
    System.out.println("Some moveable moving");
  }
}


public class GenericInterface {
  public static void main(String[] args){
    new MoveFeline().move(new Cat("kissy", 1));
//    new MoveFeline().move(new Dog("kissy", 1));

    new MoveCanine().move(new Dog("Spot", 2));
//    new MoveCanine().move(new Cat("Spot", 2));


    new SomeMoveable<Dog>().move(new Dog("Spot", 2));
    new SomeMoveable<Cat>().move(new Cat("kissy", 1));
  }
}
