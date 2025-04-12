package collections_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CommonCollectionMethods {
  public static void main(String[] args) {
    //    Collection<String> coll = new ArrayList<>();
    Collection<String> coll = Arrays.asList("Lucy", "April", "Lucy");

    coll.add("Lucy");
    coll.add("April");
    coll.add("Lucy");
    System.out.println(coll);
    System.out.println(coll.remove("Lucy"));
    System.out.println(coll);
    System.out.println(coll.isEmpty());
    System.out.println(coll.size());
    System.out.println(coll.contains("John"));
    System.out.println(coll.contains("Lucy"));
    System.out.println(coll.removeIf(s -> s.startsWith("A")));
    coll.forEach(System.out::println);
    coll.clear();
    coll.forEach(System.out::println);
  }
}
