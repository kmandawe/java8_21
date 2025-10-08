package collections_generics;

import java.util.HashMap;
import java.util.Map;

class Contact2 {
  private int age;
  private String name;

  Contact2(String name, int age) {
    this.age = age;
    this.name = name;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + age;
    hash = 89 * hash + this.name.length();
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Contact2) {
      Contact2 other = (Contact2) obj;
      return this.name.equals(other.name) && this.age == other.age;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Contact{" + "age=" + age + ", name='" + name + '\'' + '}';
  }
}

public class ContactTest {
  private static Map<Contact2, String> contacts = new HashMap<>();
  public static void main(String[] args){
    Contact2 john = new Contact2("John", 33);
    Contact2 peter = new Contact2("Peter", 34);
    System.out.println("john.hashcode = " + john.hashCode());
    System.out.println("peter.hashcode = " + peter.hashCode());

    contacts.put(john, "Irish");
    contacts.put(peter, "American");

    System.out.println(contacts.get(john));
    System.out.println(contacts.get(peter));

    Contact2 mary = new Contact2("Mary", 21);
    System.out.println("mary.hashcode = " + mary.hashCode());
    contacts.put(mary, "engineer");
    otherScope();
    System.out.println("After otherScope(): " + contacts.get(mary));

    testJane();
    // HashMaps do not maintain order
    System.out.println(contacts);
  }
  public static void otherScope(){
    Contact2 anotherMary = new Contact2("Mary", 21);
    System.out.println("anotherMary.hashcode = " + anotherMary.hashCode());
    // Separate object used as a key to access the Map!
    System.out.println("In otherScope(): " + contacts.get(anotherMary));

    // the next line overwrites mary with anotherMary as a key because:
    //  a) their hashcodes are the same
    //  b) they are both equal accdg to equals()
    contacts.put(anotherMary, "accountant");
  }

  public static void testJane() {
    // "jane" will result in the same hashcode as "mary" or "anotherMary"
    // because their ages are the same and "mary" and "jane" each have
    // 4 letters. Thus, the hashing algorithm  will find the same bucket.
    // The equals() method now however finds a different key because we
    // are searching based on "jane" within the bucket and not for "mary" as above.
    // As a result, when we do the "get", we get "nurse" and not "accountant"
    Contact2 jane = new Contact2("Jane", 21);
    System.out.println("jane.haschode = " + jane.hashCode());
    contacts.put(jane, "nurse");
    System.out.println("In testJane(): " + contacts.get(jane));
  }
}
