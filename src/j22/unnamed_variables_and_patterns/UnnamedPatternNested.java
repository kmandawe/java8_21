package j22.unnamed_variables_and_patterns;

record Address(String city, String country) {}
record Person(String name, int age, Address address) {}

public class UnnamedPatternNested {
  static void main(){
    Person person = new Person("Mary  ", 30, new Address("New York", "USA"));

    if (person instanceof Person(String name, int age, Address(String city, String country))) {
      System.out.println(name + " lives in " + country);
    }
    // now, both 'age' and 'city' are unnamed variables
    if (person instanceof Person(String name, _, Address(_, String country))) {
      System.out.println(name + " lives in " + country);
    }
  }
}
