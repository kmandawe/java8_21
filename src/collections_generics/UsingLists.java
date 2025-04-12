package collections_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UsingLists {
  public static void main(String[] args) {
    factoryMethods();
    System.out.println("====== Array List =====");
    arrayList();
    System.out.println("====== Stack =====");
    stack();
    System.out.println("====== Linked List =====");
    linkedList();
  }

  private static void factoryMethods() {
    String[] array = new String[] {"Alpha", "Beta", "Charlie"};
    List<String> asList = Arrays.asList(array);
    List<String> of = List.of(array);
    List<String> copy = List.copyOf(asList);

    array[0] = "Delta";
    System.out.println(Arrays.toString(array));
    System.out.println(asList);

    asList.set(1, "Echo");
    System.out.println(Arrays.toString(array));
    System.out.println(asList);

    //    of.add("Foxtrot");
  }

  public static void arrayList() {
    List<String> list = new ArrayList<>();
    list.add("Alan");
    list.add("Alan");
    list.add(1, "Sean");
    list.add("Mary");
    list.add("Mary");
    System.out.println(list);
    System.out.println(list.get(1));
    list.remove(0);
    list.remove("Mary");
    System.out.println(list);
    list.set(0, "Jack");

    list.replaceAll(name -> name + " Kennedy");
    System.out.println(list);
  }

  private static void stack() {
    Stack<String> stack = new Stack<>();
    stack.push("Andrea");
    stack.push("Barbara");
    stack.push("Caroline");
    System.out.println(stack);

    System.out.println("Top of stack: " + stack.peek());
    System.out.println("Popped: " + stack.pop());
    stack.push("Helen");
    System.out.println(stack);
  }

  private static void linkedList() {
    LinkedList<String> names = new LinkedList<>();
    names.add("Colin");
    names.add("David");
    names.addFirst("Brian");
    names.addLast("Edward");
    System.out.println(names);

    names.remove("David");
    names.removeFirst();
    names.removeLast();
    System.out.println(names);
  }
}
