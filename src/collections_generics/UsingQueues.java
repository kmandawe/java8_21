package collections_generics;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import streams.Book;

public class UsingQueues {
  public static void main(String[] args) {
    System.out.println("===== Linked List Queue ======");
    linkedListQueue();
    System.out.println("===== ArrayDeque ======");
    arrayDeque();
    System.out.println("===== Priority Queue Natural Ordering ======");
    priorityQueueNaturalOrdering();
    System.out.println("===== Priority Queue Different Ordering ======");
    priorityQueueDifferentOrdering();
  }

  public static void linkedListQueue() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.offer(2);
    queue.add(3);
    queue.offer(4);

    System.out.println(queue.element());
    System.out.println(queue.peek());
    System.out.println(queue);

    System.out.println(queue.remove());
    System.out.println(queue.poll());
    System.out.println(queue);
  }

  public static void arrayDeque() {
    Deque<Integer> numbers = new ArrayDeque<>();
    numbers.add(1);
    numbers.addFirst(2);
    numbers.offerFirst(3);
    System.out.println("Head: " + numbers.getFirst() + ". Head: " + numbers.peekFirst());
    numbers.addLast(4);
    numbers.offerLast(5);
    numbers.removeFirst();
    numbers.pollFirst();
    numbers.removeLast();
    numbers.pollLast();
    System.out.println(numbers);

    System.out.println(numbers.offer(11));
    System.out.println(numbers.offer(12));
    System.out.println(numbers.peek());
    System.out.println(numbers.poll());
    System.out.println(numbers.poll());
    System.out.println(numbers.poll());
    System.out.println(numbers.poll());
  }

  private static void priorityQueueNaturalOrdering() {
    Queue<String> names = new PriorityQueue<>();
    names.add("V");
    names.add("P");
    names.add("A");
    Iterator<String> itNames = names.iterator();
    while (itNames.hasNext()) {
      System.out.print(names.poll() + " ");
    }

    System.out.println();
    Queue<Integer> numbers = new PriorityQueue<>();
    numbers.add(11);
    numbers.add(5);
    numbers.add(2);
    Iterator<Integer> itNumbers = numbers.iterator();
    while (itNumbers.hasNext()) {
      System.out.print(numbers.poll() + " ");
    }
  }

  private static void priorityQueueDifferentOrdering() {
    Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());
    Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);
    booksByTitle.add(new Book("Java", 55.0));
    booksByTitle.add(new Book("Python", 23.0));
    booksByTitle.add(new Book("C++", 99.0));
    System.out.println("Ordering by title:");
    Iterator<Book> itBooksByTitle = booksByTitle.iterator();
    while (itBooksByTitle.hasNext()) {
      Book book = booksByTitle.poll();
      System.out.println(book);
    }

    Comparator<Book> comparatorPrice = Comparator.comparing(book -> book.getPrice());
    Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
    booksByPrice.add(new Book("Java", 55.0));
    booksByPrice.add(new Book("Python", 23.0));
    booksByPrice.add(new Book("C++", 99.0));

    System.out.println("Ordering by price:");
    Iterator<Book> itBooksByPrice = booksByPrice.iterator();
    while (itBooksByPrice.hasNext()) {
      Book book = booksByPrice.poll();
      System.out.println(book);
    }
  }
}
