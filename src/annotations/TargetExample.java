package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
//@Target(ElementType.TYPE_USE)
@interface DataItem {}

@DataItem class X {}
@DataItem interface Y {}

class Z {
  @DataItem int a;
  @DataItem static int b;

  @DataItem Z() {}
  void m1(@DataItem int a) {}
}

@Target(ElementType.TYPE_USE)
@interface WildCard {}

class X1 {
  @WildCard int x;
  @WildCard static int y;

  void m1(@WildCard int a) {
    @WildCard int z = 0;
    var x1 = new @WildCard X1();

    int n = (@WildCard int)23.9;
  }
}

public class TargetExample {

}
