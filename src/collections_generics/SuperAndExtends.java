package collections_generics;

import java.util.ArrayList;
import java.util.List;

class Animal1 {}
class Dog1 extends Animal1 {}
class Terrier extends Dog1 {}
class Cat1 extends Animal1 {}
class Manx extends Cat1 {}

public class SuperAndExtends {
  public static void addAnimal(Animal1[] animals) {
    animals[0] = new Dog1();
    animals[1] = new Cat1();  // ArrayStoreException generated - JVM knows the type
  }
  public static void addAnimal(List<Animal1> animals) {
    animals.add(new Dog1());
  }

  public static void main(String[] args){
    // 1a. Polymorphic assignments
    // Generics came in Java 5. Type erasure required to support legacy code.
    // Thus, generics offer compile-time protection.
    // Arrays have similar issues: (polymorhpic assigments) but the difference is
    // in how the compiler and JVM behave. Due to type erasure with generics,
    // the JVM does not know the types; with arrays the JVM does.

    // First, let's look at arrays:
    Dog1[] dogs0 = {new Dog1(), new Dog1()};
    addAnimal(dogs0);

    // polymorphism ok for the base type; List -> Arraylist
    List<Cat1> cats1 = new ArrayList<>();
    // polymorphism not ok for the generic type; Animal -> Cat
//    List<Animal1> animals1 = new ArrayList<Cat>();
    List<Cat1> cats2 = new ArrayList<Cat1>(); // generic types on both sides must match
    List<Cat1> cats3 = new ArrayList<>();
    // as the JVM does not know the types (stripped out during type-erasure), the compiler
    // has to step in.
//    addAnimal(cats2);

    // 'extends' - polymorphic assigment
    // Note: extends is read-only
    List<? extends Animal1> animals1 = new ArrayList<Animal1>();
//    animals1.add(new Animal1());
    List<? extends Animal1> animals2 = new ArrayList<Dog1>();
    List<? extends Animal1> animals3 = new ArrayList<Cat1>();
    List<? extends Animal1> animals4 = new ArrayList<Terrier>();
    List<? extends Animal1> animals5 = new ArrayList<Manx>();
//    List<? extends Animal1> animals6 = new ArrayList<Object>();

    // 'super' - polymorphic assignments
    List<? super Dog1> dogs1 = new ArrayList<Dog1>();
    dogs1.add(new Dog1()); // now can add to the list
    List<? super Dog1> dogs2 = new ArrayList<Animal1>();
    List<? super Dog1> dogs3 = new ArrayList<Object>();
//    List<? super Dog1> dogs4 = new ArrayList<Terrier>();

    // 2. declarations for 'extends' and 'super' examples
    List<Object>  objects = new ArrayList<>(); objects.add(new Object());
    List<Animal1> animals = new ArrayList<>(); animals.add(new Animal1());
    List<Cat1> cats = new ArrayList<>(); cats.add(new Cat1());
    List<Manx> manxs = new ArrayList<>(); manxs.add(new Manx());
    List<Dog1> dogs = new ArrayList<>(); dogs.add(new Dog1());
    List<Terrier> terriers = new ArrayList<>(); terriers.add(new Terrier());

    // 3. extends
      // ext(List<? extends Animal1> list) => readonly;
    ext(animals); // Animal is-an Animal - OK
    ext(cats); // Cat is-an Animal - OK
    ext(manxs); // Max is-an Animal - OK
    ext(dogs); // Dog is-an Animal - OK
    ext(terriers); // Terrier is-an Animal - OK
//    ext(objects); // Object is-not an Animal - not OK

    // 4. super
      // spr(List<? super Cat1> list) => modifiable
    spr(cats); // Cat is-a Cat
    spr(animals); // Animal is a supertype of Cat - OK
    spr(objects); // Object is a supertype of Cat - OK
//    spr(dogs);  // compiler error: Dog is not a Cat nor a supertype of Cat - not OK
//    spr(terriers);  // compiler error: Terrier is not a Cat nor a supertype of Cat - not OK
//    spr(manxs); // compiler error: Manx is not a superType of Cat - not OK
  }

  public static void ext(List<? extends Animal1> animals) { // "upper-bound" is Animal
    // 'extends' implies readonly
    // IN: List<Animal>, List<Cat>, List<Manx>, List<Dog>, List<Terrier>
    // If 'extends' allowes us to add to 'list', then we could take in
    // a List of Cat's and add a Dog to it - thereby breaking type safety.
    for (Animal1 animal : animals) {
      System.out.println(animal);
    }
  }

  public static void spr(List<? super  Cat1> list) { // The "lower-bound" is Cat
    // IN: Cat, Animal, Object
    // The only objects that can safely be added are any type of Cat (including subtypes)
    // because the method could be getting in a list of Animals or Objects (or Cats).
    list.add(new Cat1());   // Cat is-a Cat (Cat is-an Animal, Cat is-an Object)
    list.add(new Manx()); // Man-x is-a Cat (Manx is-an Animal, Man-x is an Object

//    list.add(new Dog1()); // Dog is not a Cat
//    list.add(new Animal1()) // Animal is not a Cat (Cat is an Animal)

//    for (Cat1 cat : list) {     // compiler error: - 'list' passed in could be 'Object's
//      System.out.println(cat);
//    }

//    for (Animal1 animal : list) {   // compiler error: - 'list' passed in could be 'Object's
//      System.out.println(animal);
//    }

    for (Object object : list) {
      System.out.println(object);
    }
  }
}
