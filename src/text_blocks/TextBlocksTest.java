package text_blocks;

public class TextBlocksTest {
  public static void textBlocks() {
    // 1. A text block is a String object (immutable and interned)
    String sName = "Sean Kennedy";
    String tbName = """
      Sean Kennedy""";
    System.out.println(sName.equals(tbName)); // true
    System.out.println(sName == tbName);    // true

    // 2. String methods can be applied to a text block
    System.out.println(tbName.substring(5));

    // 3. Text blocks starts with """ followed by a line terminator
//    String tb1 = """abc""";
//    String tb2 = """abc
//      """;
    String tb3 = """
      abc
      """;
    System.out.println(tb3);


  }
  public static void main(String[] args) {
//    textBlocks();
    jsonTraditionalStyle();
    jsonTextBlock();
  }

  public static void jsonTraditionalStyle() {
    String text = "{\n" +
        "  \"name\": \"John\",\n" +
        "  \"age\": 25,\n" +
        "  \"address\": \"Main Street, Dublin\"\n" +
        "}";
    System.out.println(text);
  }

  public static void jsonTextBlock() {
    String text = """
        {
          "name": "John",
          "age": 25,
          "address": "Main Street, Dublin"
        }
        """;
    System.out.println(text);
    System.out.println(1234);
  }
}
