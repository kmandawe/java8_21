package collections_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class TraversingCollections {
  public static void main(String[] args) {
    //    addListUnsupportedOperationException();
    //    addListConcurrentModificationException();
    //        addListUsingListIterator();
    //        addListUsingCopyOnWriteCollection();
    //        removeListUsingIterator();
    //        removeListUsingRemoveIf();
    //        addSetDeferredInsertion();
    //        addSetUsingCopyOnWriteCollection();
    //     removeSetUsingIterator();
    //    removeSetUsingRemoveIf();

    // Adding to a map
    //    addMapDeferredInsertion();
    //    addMapUsingConcurrentHashMap();
    //    removeMapUsingIterator();
    removeMapUsingStreams();
  }

  private static void addListUnsupportedOperationException() {
    //    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    List<String> names = List.of("Alice", "Bob", "Charlie");
    names.add("SK");
    names.set(0, names.get(0).toUpperCase());
    System.out.println(names);
  }

  private static void addListUsingCopyOnWriteCollection() {
    List<String> names = new CopyOnWriteArrayList<>(Arrays.asList("Alice", "Bob", "Carol"));
    for (String name : names) {
      if (name.equals("Bob")) {
        names.add("David");
      }
    }
    System.out.println(names);
  }

  private static void addListConcurrentModificationException() {
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
    for (String name : names) {
      if (name.equals("Bob")) {
        names.add("David");
      }
    }
  }

  private static void addListUsingListIterator() {
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
    for (var iterator = names.listIterator(); iterator.hasNext(); ) {
      String name = iterator.next();
      if (name.equals("Bob")) {
        iterator.add("David");
      }
    }
    System.out.println(names);
  }

  private static void removeListUsingIterator() {
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));
    for (var iterator = names.iterator(); iterator.hasNext(); ) {
      String name = iterator.next();
      if (name.equals("Bob")) {
        iterator.remove();
      }
    }
    System.out.println(names);
  }

  private static void removeListUsingRemoveIf() {
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));
    names.removeIf(name -> name.equals("Bob"));
    System.out.println(names);
  }

  private static void addSetDeferredInsertion() {
    Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
    Set<String> toAdd = new HashSet<>();
    for (String element : names) {
      if ("Alice".equals(element)) {
        toAdd.add("Emily");
      }
    }
    names.addAll(toAdd);
    System.out.println(names);
  }

  private static void addSetUsingCopyOnWriteCollection() {
    Set<String> names = new CopyOnWriteArraySet<>(Set.of("Bob", "Alice", "Charlie"));
    for (String name : names) {
      if (name.equals("Alice")) {
        names.add("Emily");
      }
    }
    System.out.println(names);
  }

  private static void removeSetUsingIterator() {
    Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
    for (var iterator = names.iterator(); iterator.hasNext(); ) {
      String name = iterator.next();
      if (name.equals("Bob")) {
        iterator.remove();
      }
    }

    System.out.println(names);
  }

  private static void removeSetUsingRemoveIf() {
    Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
    names.removeIf(name -> name.equals("Alice"));
    System.out.println(names);
  }

  private static void addMapDeferredInsertion() {
    Map<String, Integer> names = new TreeMap<>(); // sorted by keys
    // again, iterator has no add() method
    names.put("Charlie", 25);
    names.put("Alice", 31);
    names.put("Bob", 21);

    Map<String, Integer> toAdd = new HashMap<>();
    for (Map.Entry<String, Integer> entry : names.entrySet()) {
      if ("Alice".equals(entry.getKey())) {
        toAdd.put("Alice", 32); // Alice's birthday!
      }
    }
    names.putAll(toAdd);
    System.out.println(names);
  }

  private static void addMapUsingConcurrentHashMap() {
    Map<String, Integer> names = new ConcurrentHashMap<>();
    names.put("Alice", 31);
    names.put("Bob", 21);
    names.put("Charlie", 39);
    names.put("Andrew", 31);

    for (var entry : names.entrySet()) {
      if (entry.getKey().equals("Alice")) {
        names.put("Emily", 24); // using Map's put() method
      }
    }
    System.out.println(names);
  }

  private static void removeMapUsingIterator() {
    Map<String, Integer> names = new TreeMap<>();
    names.put("Alice", 31);
    names.put("Bob", 21);
    names.put("Charlie", 39);
    names.put("Andrew", 31);

    // An iterator is possible here also but remember Map does not inherit from Collection so
    // we get an EntrySet version first (i.e. a Set, which IS-A Collection) and work from there.
    Iterator<Entry<String, Integer>> iterator = names.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, Integer> entry = iterator.next();
      if (entry.getValue() < 30) { // removes Bob
        iterator.remove(); // Safe removal during iteration
      }
    }
    System.out.println(names);
  }

  private static void removeMapUsingStreams() {
    Map<String, Integer> names = new TreeMap<>();
    names.put("Alice", 31);
    names.put("Bob", 21);
    names.put("Charlie", 39);
    names.put("Andrew", 31);

    // filter out/remove all names that begin with "A"
    // overwriting my original map on purpose
    names =
        names.entrySet().stream()
            .filter(entry -> !entry.getKey().startsWith("A")) // filter out names beginning with "A"
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    System.out.println(names);
  }
}
