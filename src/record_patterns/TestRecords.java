package record_patterns;

public class TestRecords {
  public static void records() {
    Person p1 = new Person("Joe Bloggs", 22);
    System.out.println(p1);
    System.out.println(p1.name() + "; " + p1.age());
    patternMatching(p1);
    patternMatching("abc");

    Pair<String> pairS = new Pair<>("Sean", "Kennedy");
    Pair<Integer> pairI = new Pair<>(10, 20);
    patternMatching(pairS); // PM: Sean; Kennedy
    patternMatching(pairI); // PM: 10; 20
  }

  public static void patternMatching(Object obj) {
    if (obj instanceof Person p) {
      System.out.println("PM: " + p.name() + "; " + p.age());
    } else if (obj instanceof Pair pair) {
      System.out.println("PM: " + pair.x() + "; " + pair.y());
    }
  }

  public static void nonNesting(Object obj) {
    if (obj instanceof  Person(String s, int nAge)) {   // record pattern
      System.out.println(s + "; " + nAge);
    }
  }

  public static void nesting(Doubles dbles) {
    if (dbles instanceof Doubles(Player p1, Player p2)) { // LVTI works here
      System.out.println(p1.person() + "; " + p1.ability());
    }
    // more complex nesting
    if (dbles instanceof Doubles(Player(Person p1, Ability ability), Player pl2)) {   // LVTI works here
      System.out.println(p1.name() + "; " + p1.age() + "; " + ability.name());
    }
  }

  static void main(){
    records();
  }
}
