package collections_generics;

import java.util.Objects;

public class Product implements Comparable<Product> {

  private Integer id;

  public Product(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + id + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int compareTo(Product o) {
    // delegate to Integer which implements Comparable<Integer>
    return id.compareTo(o.id);
  }

}
