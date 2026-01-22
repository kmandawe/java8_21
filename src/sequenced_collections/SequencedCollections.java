
void main(){
  System.out.println("SequencedCollection");
  seqColl();
  System.out.println("SequencedSet");
  seqSet();
  System.out.println("SequencedMap");
  seqMap();
}

void seqColl(){
  // A sequenced collection is a Collection whose elements have a defined encounter order
  SequencedCollection<String> seqColl = new ArrayList<>();

  seqColl.addFirst("A");
  seqColl.addFirst("B");
  seqColl.addLast("C");
  seqColl.addLast("D");
  seqColl.addLast("D");
  System.out.println(seqColl);
  System.out.println("getFirst() : " + seqColl.getFirst());
  System.out.println("getLast() : " + seqColl.getLast());
  System.out.println("removeFirst() : " + seqColl.removeFirst());
  System.out.println("removeLast() : " + seqColl.removeLast());
  System.out.println(seqColl);

  // front to last
  System.out.println("Forwards...");
  for (String s: seqColl) {
    System.out.println(s);
  }

  // reverse order
  System.out.println("Backwards...");
  for (String s: seqColl.reversed()) {
    System.out.println(s);
  }

}

void seqSet() {
  // A sequenced set is a SequencedCollection with no duplicate elements.
  SequencedSet<String> seqSet = new LinkedHashSet<>();
  seqSet.addFirst("A");
  seqSet.addFirst("B");
  seqSet.addLast("C");
  seqSet.addLast("D");
  seqSet.addLast("D");
  System.out.println(seqSet);
  System.out.println("getFirst() : " + seqSet.getFirst());
  System.out.println("getLast() : " + seqSet.getLast());
  System.out.println("removeFirst() : " + seqSet.removeFirst());
  System.out.println("removeLast() : " + seqSet.removeLast());
  System.out.println(seqSet);

  //front to last
  System.out.println("Forwards...");
  for (String s: seqSet) {
    System.out.println(s);
  }

  // reverse order
  System.out.println("Backwards...");
  for (String s: seqSet.reversed()) {
    System.out.println(s);
  }
}

void seqMap() {
  // A sequenced map is a Map whose entries have a defined encounter order.
  SequencedMap<Integer, String> seqMap = new LinkedHashMap<>();

  seqMap.putFirst(1, "Adam");
  seqMap.putFirst(2, "Brian");
  seqMap.putLast(3, "Charlie");
  seqMap.putLast(4, "David");
  System.out.println(seqMap);
  System.out.println("firstEntry() : " + seqMap.firstEntry());
  System.out.println("lastEntry() : " + seqMap.lastEntry());
  System.out.println("pollFirstEntry() : " + seqMap.pollFirstEntry());
  System.out.println("pollLastEntry() : " + seqMap.pollLastEntry());
  System.out.println(seqMap);

  // front to last
  System.out.println("Forwards...");
  for (Map.Entry<Integer, String> e: seqMap.entrySet()) {
    System.out.println(e.getKey() + "; " + e.getValue());
  }

  // reverse order
  System.out.println("Backwards...");
  for (Map.Entry<Integer, String> e: seqMap.reversed().entrySet()) {
      System.out.println(e.getKey() + "; " + e.getValue());
    }
}



