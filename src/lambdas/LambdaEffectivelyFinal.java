package lambdas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
  String name = "";

  public static void main(String[] args){
    List<String> al = new ArrayList<>();
    al.add("John");

    int x = 12;

    Predicate<String> lambda = s -> {
      new LambdaEffectivelyFinal().name = "Kennedy";
      System.out.println("x == " + x);
      return s.isEmpty() && x % 2 == 0;
    };


    filterData(al, lambda);
    System.out.println(al);

    new LambdaEffectivelyFinal().name = "Sean";

    filterData(al, lambda);
  }

  public static void filterData(List<String> list, Predicate<String> lambda){
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()){
      if(lambda.test(iterator.next())){
        iterator.remove();
      }
    }
  }
}
