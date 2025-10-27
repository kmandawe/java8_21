package annotations;

enum Device { LAPTOP, PHONE }

@interface Human {} // marker annotation

@interface OnWeb {
  int startTime () default 9;
  int hoursPerDay ();

  int PEAK_TIME_START = 19; // constants, public static final by default
  public static final int PEAK_TIME_END = 22;

//  Integer turnOff(); // wrappers not allowed
  String name() default "SK";
  Device consume() default Device.LAPTOP;
  Class humanOrBot() default Human.class;
  Human extraInfo() default @Human; // Note: 'new' keyword not used to create annotation instances
  String[] sites() default {"S", "K"};
}

@OnWeb(hoursPerDay = 8) @Human class Student {}

@OnWeb(hoursPerDay = 3, startTime = 10)
@Human
class Worker {}

public class CustomAnnotations {

}
