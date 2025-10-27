package annotations;

import java.lang.annotation.Repeatable;

// container annotation
@interface Batteries {
    Battery[] value();
}

@Repeatable(Batteries.class)
@interface Battery {
  String level();
  boolean recharge();
}

@Battery(level = "high", recharge = false)
@Battery(level = "low", recharge = true)
class ElectricCar {}


public class RepeatableExample {


}
