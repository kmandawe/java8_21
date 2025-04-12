package collections_generics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class UsingQueues {
  public static void main(String[] args) {
    System.out.println("===== Linked List Queue ======");
    linkedListQueue();
    System.out.println("===== ArrayDeque ======");
    arrayDeque();
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
}
