package streams;

class Person {
  private String firstName, lastName;
  private int age;

  public Person(String firstName, int age) {
    this.firstName = firstName;
    this.age = age;
  }

  Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public int getAge() {
    return age;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
  }
}
