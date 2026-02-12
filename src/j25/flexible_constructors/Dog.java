package j25.flexible_constructors;

import java.util.Objects;

public class Dog extends Animal {
  private String theBreed;
  public Dog(String aName, String aBreed) {
//    super(aName); // pre-Java25, super() must be first statement in constructor
    //  check breed is valid, if not valid, fail fast
    // Pre-java25, if breed is invalid, the super(aName) was unnecessary effort
    String breed = Objects.requireNonNull(aBreed, "breed must not be null").trim();
    if (breed.isEmpty()) {
      throw new IllegalArgumentException("breed must not be blank");
    }
    // breed is valid
    theBreed = aBreed ; // init is ok in prologue
//    logDetails(); // cannot call instance methods before super(...)
//    String b = this.breed;  // cannot read this...
    super(aName);
  }

  @Override
  public void logDetails() {
    super.logDetails();
    IO.println("The Dog breed is " + theBreed);
  }

  void main(){
    Animal animal = new Dog("Rex", "Terrier");
  }
  public Dog() {
    super();  // would be inserted by the compiler, if no code in method at all
  }
}

// Instance main() needs a no-arg constructor
