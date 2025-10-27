package annotations;

import java.lang.annotation.Inherited;

//@interface BreatheInWater {}
@Inherited @interface BreatheInWater {}

@BreatheInWater class Fish {}

class Trout extends Fish {}


public class InheritedExample {

}
