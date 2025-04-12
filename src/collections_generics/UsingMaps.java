package collections_generics;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UsingMaps {
  public static void main(String[] args){
    Map<String, Integer> map = new TreeMap<>();
    map.put("John", 18);
    map.put("Mary", 21);
    map.put("Chris", 33);
    System.out.println(map.containsKey("John"));
    System.out.println(map.containsValue(18));
    System.out.println(map.isEmpty());
    System.out.println(map.get("John"));
    for (String name : map.keySet()){
      System.out.println(name);
    }
    for (Integer age : map.values()){
      System.out.println(age);
    }
    System.out.println(map.containsKey("Paul"));
    System.out.println(map.containsValue(21));
    System.out.println(map.size());
    map.clear();
    System.out.println(map.size());

    map.put("John", 18);
    map.put("Mary", 21);
    map.put("Chris", 33);

    map.forEach((k,v) -> System.out.println(k + " maps to " + v));

    map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    Set keys = map.keySet();
    map.put("Mike", null);
    map.putIfAbsent("Chris", 99);
    map.putIfAbsent("Mike", 55);
    map.putIfAbsent("Luke", 31);

    Integer original = map.replace("Chris", 81);
    System.out.println(map);

    map.replaceAll((name, age) -> name.length());
    System.out.println(map);

    map.remove("Mike");
  }
}
