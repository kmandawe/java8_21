package annotations;

@interface Team {
  String value() default "Soccer";
  int numPlayers() default 2;
}

class Sport {
  @Team(numPlayers = 6, value = "Volleyball") void beach() {}
  @Team(value = "Tennis") void strawberriesAndCream() {}

  @Team("Curling") void slow() {}
}

@interface Quiz {
  String[] topics();
}

class Competitor {
  @Quiz(topics = {"General Knowledge", "Music"}) String favouriteTopic;
  @Quiz(topics = {"Sport"}) String lastFavouriteTopic;
  @Quiz(topics = {"Sport"}) String leastOtherFavouriteTopic;

//  @Quiz(topics = "Sport", "Jazz") String topic1; // {} missing
//  @Quiz(topics = null) String topic1; // constant expression required (even {} is ok)


  void prepare() {}
}

@interface Colours {
  String[] value();
}

class TestRainbow {
  @Colours(value = {"Red"}) String colour1;
  @Colours(value = "Red") String colour2;
  @Colours({"Red"}) String colour3;
  @Colours("Red") String colour4;
}

public class Shorthand {}
