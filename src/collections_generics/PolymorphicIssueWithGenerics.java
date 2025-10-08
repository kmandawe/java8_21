package collections_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolymorphicIssueWithGenerics {
  public static void main(String[] args){
    // The issue
    List<Double> doubles = new ArrayList<>();
    doubles.add(12.3);

//    List<Object> objects = doubles; // COMPILE ERROR
//    objects.add("This is a string");

    // A different variation
    List<String> names = new ArrayList<>();
    names.add("Sean");
//    showList(names);
  }

  private static void showList(List<Object> names) {
    for (Object name : names) {
      System.out.println(name);
    }
  }
}
