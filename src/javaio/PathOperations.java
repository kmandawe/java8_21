package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {
  public static void main(String[] args) {
//    pathInfo(Paths.get("/Users/kennethmandawe/Projects/loyalsphere/app/routing-app/pom.xml"));
    pathInfo(Path.of("abc/def/ghi/jkl"));
  }
  public static void pathInfo(Path path){
    System.out.println("toString: "+path);
    System.out.println("getNameCount: " + path.getNameCount()); // 7
    for(int i=0; i<path.getNameCount(); i++){
      // getName(0): Users   => root is NOT a name element (see Path.of("/").getName(0); on line 22)
      System.out.println("getName("+i+"): "+path.getName(i));
    }
    System.out.println("getFileName: " + path.getFileName());   // pom.xml
    System.out.println("getParent: " + path.getParent());       // /Users/kennethmandawe/Projects/loyalsphere/app/routing-app
    System.out.println("getRoot: " + path.getRoot());           // /
//        System.out.println("exception: " + Path.of("/").getName(0)); // java.lang.IllegalArgumentException

    System.out.println("subpath(0,3): "+path.subpath(0, 3));    // Users/kennethmandawe/Projects
    System.out.println("subpath(1,4): "+path.subpath(1, 4));    // kennethmandawe/Projects/loyalsphere
    System.out.println("subpath(2,3): "+path.subpath(2, 3));    // Projects

    System.out.println("isAbsolute: "+path.isAbsolute());       // true
  }
}
