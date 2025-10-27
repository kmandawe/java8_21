package annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Book {

  /**
   * How to consume the Book.
   * @deprecated Use readOnline() instead.
   */
  @Deprecated(since = "2.0", forRemoval = true)
  public static void print() {}

  public static void readOnline() {}

  public static Integer preview(List<String> pages) {
    return pages.size();
  }
}

public class CommonBuiltInAnnotationsExtra {
  public static void main(String[] args){
    CommonBuiltInAnnotationsExtra ann = new CommonBuiltInAnnotationsExtra();
    ann.testDeprecated();
    ann.testUnchecked();

    abuseVarargs(new ArrayList<>());

  }

  @SuppressWarnings("deprecation")
  public void testDeprecated() {
    Book.print();
  }

  @SuppressWarnings("unchecked")
  public void testUnchecked() {
    Book.preview(new ArrayList<>());
    Book.preview(new ArrayList());
  }

  @SafeVarargs
  static int abuseVarargs(List<Integer>... list) {
    Object[] oa = list;
    oa[0] = Arrays.asList("uh-ho");
    return list[0].get(0);
  }
}
