package collections_generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {

  public static void main(String[] args) {
//    comparable(new Dog[] {new Dog("Spot", 2), new Dog("Rover", 7)}); // just in-time array
//    comparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

    comparator(new Dog[] {new Dog("Spot", 2), new Dog("Rover", 7)}); // just in-time array
//    comparator(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));
  }

  private static void comparable(Dog[] dogArray) {
    Arrays.sort(dogArray);
    System.out.println(Arrays.toString(dogArray));
  }

  private static void comparable(List<Dog> dogList) {
    Collections.sort(dogList);
    System.out.println(dogList);
  }

  public static void comparator(Dog[] dogArray) {
    Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
    Arrays.sort(dogArray, byAge);
    System.out.println(Arrays.toString(dogArray));

    Comparator<Dog> byAgeReversed = byAge.reversed();
    Arrays.sort(dogArray, byAgeReversed);
    System.out.println(Arrays.toString(dogArray));
  }

  public static void comparator(List<Dog> dogList) {
    Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
    dogList.sort(byAge);
    System.out.println(dogList);

    Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
    dogList.sort(byAgeReversed);
    System.out.println(dogList);

  }
}
