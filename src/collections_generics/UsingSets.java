package collections_generics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsingSets {
  public static void main(String[] args) {
    factoryMethods();
    System.out.println("===== Tree Set ======");
    treeSet();
    System.out.println("===== Hash Set ======");
    hashSet();
    System.out.println("===== Linked Hash Set ======");
    linkedHashSet();
  }

  private static void factoryMethods() {
    Set<String> of = Set.of("a", "b", "c");
    Set<String> copy = Set.copyOf(of);

    //    of.add("d");
    //    copy.add("d");

    //    of.remove("a");
  }

  public static void treeSet() {
    Set<String> names = new TreeSet<>();
    names.add("John");
    names.add("John");
    names.add("Helen");
    names.add("Anne");
    System.out.println(names);

    Set<Integer> numbers = new TreeSet<>();
    numbers.add(23);
    numbers.add(Integer.valueOf("21"));
    numbers.add(Integer.valueOf("11"));
    numbers.add(99);
    System.out.println(numbers);
  }

  private static void hashSet() {
    Set<Contact> contactsHS = new HashSet<>();
    contactsHS.add(new Contact("zoe", 45));
    contactsHS.add(new Contact("zoe", 45));
    contactsHS.add(new Contact("alice", 34));
    contactsHS.add(new Contact("andrew", 35));
    contactsHS.add(new Contact("brian", 36));
    contactsHS.add(new Contact("carol", 37));

    for (Contact contact : contactsHS) {
      System.out.println(contact);
    }
    System.out.println();
  }

  public static void linkedHashSet() {
    Set<Contact> contactsLHS = new LinkedHashSet<>();
    contactsLHS.add(new Contact("zoe", 45));
    contactsLHS.add(new Contact("zoe", 45));
    contactsLHS.add(new Contact("alice", 34));
    contactsLHS.add(new Contact("andrew", 35));
    contactsLHS.add(new Contact("brian", 36));
    contactsLHS.add(new Contact("carol", 37));

    for (Contact contact : contactsLHS) {
      System.out.println(contact);
    }
  }
}
