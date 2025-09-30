package collections_generics;

import java.util.Objects;

public class Dog implements Comparable<Dog> {

  private String name;
  private Integer age;

  public Dog(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Dog dog = (Dog) o;
    return Objects.equals(name, dog.name);
  }

  @Override
  public int compareTo(Dog o) {
    return name.compareTo(o.name);
  }
}
