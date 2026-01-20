package text_blocks;

public class TextBlocks {
  public static void main(String[] args) {
    System.out.println(2 | 4);
    String sName = "Sean Kennedy";
    sName.substring(1, 2);
    String tbName =
        """
  Sean Kennedy""";
    System.out.println(sName.equals(tbName));
    System.out.println(sName == tbName);

    System.out.println(tbName.substring(5));

    //    String tb1 = """abc""";   // no line terminators
    //  String tb2 = """abc  // not followed by a line terminator
    // """;
    String tb3 =
        """
        abc
        """;
    System.out.println(tb3);

    String sQuote =
        "Hamlet: \"There is nothing either good or bad, " + "but thinking makes it so.\"";
    System.out.println(sQuote);
    String tbQuote =
        """
        Hamlet: "There is nothing either good or bad, \
        but thinking makes it so." """;
    System.out.println(tbQuote);

    String tbBookTitle1 =
        """
          Java
          Memory
          Management
          """;
    System.out.println(tbBookTitle1);
    String tbBookTitle2 =
        """
          Java
          Memory
          Management""";
    System.out.println(tbBookTitle2);
  }
}
