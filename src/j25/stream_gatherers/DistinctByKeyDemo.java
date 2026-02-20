package j25.stream_gatherers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

// Task: From a list of users, keep the first User for each distinct email (distinct-by-key)
//      a) Why distinct() does not work?
//      b) The old way using a Set outside the pipeline.
//      c) The new way using a custom reusable Gatherer.
//      d) Reuse the Gatherer to keep the first User for each distinct 'purchases' value.
public class DistinctByKeyDemo {
  void main(){
    IO.println("== Distinct by key (email) ==");

    var users = List.of(
        new User(1, "a@x.com", 2),
        new User(1, "a@x.com", 2),  // exact duplicate => disctinct() removes this
        new User(2, "a@x.com", 99), // same email as a@x.com but different = distinct() does NOT remove this
        new User(3, "b@x.com", 1)
    );

    //  a)
    var distinctUsers = users.stream().distinct().toList();
    IO.println("distinct() => " + distinctUsers);

    //  b)
    // Unique emails: We want the first "a@x.com" and "b@x.com" (so 2 users in total)
    // OLD WAY (state outside pipeline) - considered a workaround as I had to create and manage
    // external mutable state (seenEmails)
    var seenEmails = new HashSet<String>();
    var distinctUsersOldWay = users.stream()
        .filter(user -> seenEmails.add(user.email()))
        .toList();
    IO.println("distinct() old way => " + distinctUsersOldWay);

    // c)
    // NEW WAY (custom intermediate op inside pipeline)
    var newDistinctByEmail = users.stream()
        .gather(distinctByKey(User::email))
        .toList();
    IO.println("email: New (gather distinctBykey) => " + newDistinctByEmail);
  }

  // sample call: .gather(distinctByKey(User::email))
  // Gatherer<T, A, R> - T is the input type,
  //                     A is state type,
  //                     R is the output element type
  //                   - "?" hides the state type from callers (implementation detail)
  // T = the stream element type - User
  // K = the key type extracted - String for email invocation
  // State - what you keep in memory - Set<K> of seen keys (e.g., emails or purchases)
  static <T, K> Gatherer<T, ?, T> distinctByKey(Function<? super T,? extends K> keyExtractor) {
    // ofSequential => no combiner, so not parallel-capable (cannot merged per-thread state).
    // <T, Set<K>, T> => upstream supplies T; state is Set<K> of seen keys; downstream receives emitted T values.
    return Gatherer.<T, Set<K>, T>ofSequential(
        HashSet::new, // Supplier initializer: new state, executed once per pipeline evaluation <=> Set<K> seenKeys = new HashSet<>(),
        // ofGreedy integrator: process each element immediately and keep going unless downstream rejects.
        // seenKeys - my memory/scratchpad while processing; element - the next input item; downstream - the output pipe
        Gatherer.Integrator.ofGreedy((seenKeys, element, downstream) -> { // integrator
          // The integrator is the "per element" custom logic:
          //        - it gets state ("seenKeys"), the current element ("element"), and downstream
          // For each element what do I do? Do I emit it?
          K key = keyExtractor.apply(element); // extract the key (e.g., email) from the element (e.g., User)
          if (seenKeys.add(key)) {
            // Emit it. If push() returns false, downstream is done (e.g., limit/findFirst) - stop immediately.
            // This is for efficiency - we don't want our Gatherer wasting CPU cycles e.g. in a loop, when the
            // stream may be finished.
            // return true -> keep processing more input
            // return false -> stop now (short-circuit)
            return downstream.push(element); // emits 1 element here
          }
          return !downstream.isRejecting(); // if downstream is rejecting, stop (return false)
        })
        // optional finisher
        // Finisher: runs once when the stream ends (or short-circuits). For distinct-by-key,
        // there's no buffered output to flush - we emit/skip elements immediately - so nothing to do here.
//        (seenKeys, downstream) -> {}
    );
    }
}
