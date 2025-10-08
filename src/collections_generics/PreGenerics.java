package collections_generics;

import java.util.ArrayList;
import java.util.List;

public class PreGenerics {
  public static void main(String[] args){
    // A raw collection can hold any type of Object (except primitive).
    List myList = new ArrayList(); // can't enforce a type
    myList.add("Fred"); // will hold String
    myList.add(new Dog("Spot", 2)); // and Dogs
    myList.add(43); // and Integer (autoboxing)

    // As everything is treated as an Object, when you are getting something out of
    // the collection, all you have are Objects - therefore a cast is necessary
    String s = (String) myList.get(0);
    // and as we could not guarantee what was coming out
    // this cast could fail at runtime
//    String s1 = (String) myList.get(1); // ClassCastException at runtime

    // Generics takes care of both ends (putting in and getting out)
    // by enforcing the type of your collections
    // Note: generic syntax means putting the type in angle brackets
    List<String> myStringList = new ArrayList<>();
    myStringList.add("Fred");
//    myStringList.add(new Dog("Spot", 2)); // compile error
    // Because what is going IN is guaranteed, what is coming out is
    // also guaranteed => no need for cast
    String s2 = myStringList.get(0);
  }
}
