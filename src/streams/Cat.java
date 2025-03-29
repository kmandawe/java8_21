package streams;

public class Cat {
  private String name, color;
  Cat(String name, String color) {
    this.name = name;
    this.color = color;
  }

  @Override
  public String toString() {
    return "Cat{" + "name=" + name + ", color=" + color + '}';
  }
}
