package j22.unnamed_variables_and_patterns;

record Somebody(String name, int age) {}
public class UnnamedPatternRecord {
  static void main(){
    Somebody somebody = new Somebody("Andrew", 30);

    if(somebody instanceof Somebody(String name, int age)) {
      System.out.println("Name: " + name);
    }

    if(somebody instanceof Somebody(String name, int _)) {
      System.out.println("Name: " + name);
    }
  }
}
