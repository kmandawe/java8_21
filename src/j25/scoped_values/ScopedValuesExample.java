package j25.scoped_values;

import java.lang.foreign.MemorySegment.Scope;

public class ScopedValuesExample {
  // 1. Define a ScopedValue
  private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

  void main(){
    // 2. Bind a value to a scope
    // run(Runnable) - Runnable is a functional interface: void run()
    // run(Runnable) - executes the block on the current thread (does not start a new thread)
    ScopedValue.where(USER_ID, "SK-001").run(ScopedValuesExample::processUser);
//    ScopedValue.where(USER_ID, "SK-002").run(() -> processUser());
    shouldNotSeeUserId();
  }

  static void processUser(){
    // Dynamic scope: USER_ID is visible here and in any method we call inside run(...)
    // Lexical scope would be curly-brace based (like local variables): visibility depends on where codes is written
    echo("begin");
    ScopedValue.where(USER_ID, "INNER").run(() -> {
      echo("inside inner"); // INNER
      checkAccountStatus(); // INNER
    });
    echo("back to outer");
    checkAccountStatus();
    echo("end");
  }

  static void checkAccountStatus(){
    echo("checkAccountStatus...");
    applyUserPreferences();
  }

  static void applyUserPreferences(){
    echo("applyUserPreferences...");
  }

  static void echo(String msg){
    IO.println("[" + Thread.currentThread().getName() + "] " + msg + " " + USER_ID.orElse("no user-id"));
  }

  static void shouldNotSeeUserId(){
    IO.println("[" + Thread.currentThread().getName() + "] "  + "Should not see user id: " + USER_ID.orElse("no user-id"));
  }
}
