package collections_generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcard {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Sean");
    showList(names); // List<?> list = new ArrayList<String>();
    List<Dog> dogs = new ArrayList<>();
    dogs.add(new Dog("Spot", 2));
    showList(dogs);
    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("Trixy", 5));
    showList(cats);
  }

  public static void showList(List<?> list) {
    for (Object name : list) {
      System.out.println(name);
    }
//    list.add("test"); // <?> implies read-only
  }
}
