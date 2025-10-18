package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveExamples {
  public static void main(String[] args) {
    Path absolute = Paths.get("/Users/kennethmandawe/Projects/study/java8_21");
    Path relative = Path.of("nio2");
    Path file     = Path.of("name.txt");

    System.out.println("absolute.resolve(relative): "+
        absolute.resolve(relative));
    System.out.println("absolute.resolve(file): "+
        absolute.resolve(file));
    System.out.println("relative.resolve(file): "+
        relative.resolve(file));

    // trying to resolve an absolute path within anything just returns the absolute path
    System.out.println("relative.resolve(absolute): "+
        relative.resolve(absolute));
    System.out.println("file.resolve(absolute): "+
        file.resolve(absolute));
    System.out.println("absolute.resolve(absolute): "+
        absolute.resolve(absolute));

    // interesting...
    Path p1  = Path.of("dir");
    Path p2  = Path.of("sk.txt");
    System.out.println("dir.resolve(sk.txt): "+
        p1.resolve(p2));
    System.out.println("sk.txt.resolve(dir): "+
        p2.resolve(p1));
  }
}
