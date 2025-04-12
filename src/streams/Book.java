package streams;

public class Book {
  private String title, genre;
  private double price;

  Book(String title, double price) {
    this.title = title;
    this.price = price;
  }

  Book(String title, String genre) {
    this.title = title;
    this.genre = genre;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public double getPrice() {
    return price;
  }

  public String toString() {
    return title + " " + price;
  }
}
