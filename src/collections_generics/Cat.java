package collections_generics;

import java.util.Objects;

public class Cat implements Comparable<Cat>{
  private String name;
  private int age;

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass())
      return false;
    Cat cat = (Cat) o;
    return Objects.equals(name, cat.name);
  }

  @Override
  public int compareTo(Cat o) {
    return name.compareTo(o.name);
  }
}
