package record_patterns;

public record Person(String name, int age) {}   // component list, name() and age() accessors
enum Ability {WEAK, AVERAGE, STRONG}
record Player(Person person, Ability ability) {}
record Doubles(Player player1, Player player2) {}

record Pair<T> (T x, T y) {}
