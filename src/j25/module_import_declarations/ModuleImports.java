package j25.module_import_declarations;

// lots of import noise
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;

import module java.base;
import module java.desktop;

import java.util.List;

public class ModuleImports {
  void main() throws Exception {
    Path path = Path.of("data.txt");
    List<String> lines = Files.readAllLines(path);
    Map<Integer, Long> lineLengthCounts =
        lines.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
    System.out.println(lineLengthCounts);

    String longest = lines.stream().max(Comparator.comparingInt(String::length)).orElse("<none>");
    System.out.println("Longest: " + longest);
  }
}
