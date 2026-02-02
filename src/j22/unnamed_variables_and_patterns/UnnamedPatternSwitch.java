package j22.unnamed_variables_and_patterns;

public class UnnamedPatternSwitch {
  static void process(Object obj){
    switch (obj) {
      case String s -> System.out.println("It's a string.");
      case Integer i -> System.out.println("It's an integer.");
      case null, default -> System.out.println("Something else.");
    }
    switch (obj) {
      case String _ -> System.out.println("It's a string.");
      case Integer _ -> System.out.println("It's an integer.");
      case null, default -> System.out.println("Something else.");
    }
  }
  static void main(){
    process("hello");
    process(42);
    process(3.14);
  }
}
