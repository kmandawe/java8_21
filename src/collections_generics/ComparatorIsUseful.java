package collections_generics;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Worker {
  private int id;

  Worker(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Worker{" + "id=" + id + '}';
  }
}

class Boss implements Comparable<Boss> {
  private int id;

  Boss(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public int compareTo(Boss o) {
    return this.id - o.id;
  }

  @Override
  public String toString() {
    return "Boss{" + "id=" + id + '}';
  }
}

public class ComparatorIsUseful {
  public static void main(String[] args) {
    Set<Boss> bosses = new TreeSet<>();
    bosses.add(new Boss(20));
    bosses.add(new Boss(10));
    bosses.add(new Boss(15));
    System.out.println(bosses);

//    Set<Worker> workers = new TreeSet<>(); // ClassCastException: class Worker cannot be cast to Comparable
//    Set<Worker> workers = new TreeSet<>((worker1, worker2) -> worker1.getId() - worker2.getId());
    Set<Worker> workers = new TreeSet<>( Comparator.comparing(Worker::getId));
    workers.add(new Worker(30));
    workers.add(new Worker(20));
    workers.add(new Worker(10));
    workers.add(new Worker(21));

    System.out.println(workers);
  }
}
