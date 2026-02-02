package j22.unnamed_variables_and_patterns;

import java.util.List;
import java.util.stream.IntStream;

public class UnnamedVariableLoop {
  static void main(){
    String[] data = {"April", "Brendan"};

    for(String name : data) { // name not used
      System.out.println("Performing a side-effect...");
    }

    for (String _: data) {
      System.out.println("Performing a side-effect...");
    }

    List<String> names = List.of("April", "Brendan");
    names.forEach(name -> System.out.println("Performing a side-effect..."));
    names.forEach(_ -> System.out.println("Performing a side-effect..."));

    IntStream.range(0, 5).forEach( i -> System.out.println("Repeating action!"));
    IntStream.range(0, 5).forEach(_ -> System.out.println("Repeating action!"));
  }
}
