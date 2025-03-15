package lambdas;

public class Person {
  public static Integer howMany(Person... people) {
    return people.length;
  }
}
