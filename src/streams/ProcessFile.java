package streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessFile {
  public static void main(String[] args){
    List<Cat> cats = loadCats("Cats.txt");
    cats.forEach(System.out::println);
  }

  private static List<Cat> loadCats(String filename) {
    List<Cat> cats = new ArrayList<>();
    try (Stream<String> stream = Files.lines(Paths.get(filename))) {
      stream.forEach(line -> {
        String[] catsArray = line.split("/");
        cats.add(new Cat(catsArray[0], catsArray[1]));
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return cats;
  }
}
