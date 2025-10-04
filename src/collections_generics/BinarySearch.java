package collections_generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
  public static void main(String[] args){
//    searchStrings();
    searchCats();
  }

  public static void searchStrings() {
    List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
    Collections.sort(names); // natural order sort - alphabetic for strings
    System.out.println(names);
    // if found, return index
    System.out.println(Collections.binarySearch(names, "John"));
    // if not found, return: -(indexItWouldHaveIfPresent) - 1
    // "Laura" this is: -(2) -1 = -2 -1 = -3
    System.out.println(Collections.binarySearch(names, "Laura"));
  }

  private static void searchCats() {
    Cat fluffy = new Cat("Fluffy", 1);
    Cat bella = new Cat("Bella", 5);
    List<Cat> catList = Arrays.asList(fluffy, bella);

    Collections.sort(catList);
    System.out.println(catList);
    System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella));

    Comparator<Cat> byAge = Comparator.comparing(Cat::getAge);
    catList.sort(byAge);
    System.out.println(catList);

    System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella, byAge));
  }
}
