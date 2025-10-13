package localisation;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleSearching {
  public static void main(String[] args){
//    defaultLocaleIrrelevant();
//  ignoreAmericanBundle();
  usingDefaultLocale();
  }

  public static void defaultLocaleIrrelevant() {
    Locale.setDefault(new Locale("en", "IE"));
    Locale localeCA = new Locale("en", "CA");
    // Search path:
    //  1a. Mill_en_CA.java
    //  1b. Mill_en_CA.properties (found this file - hierarchy is now decided)
    //  2. Now we are locked into a specific hierarchy (this means that the)
    //      default locale Mill_en_IE.java/properties is irrelevant.
    //      The hierarch searched is now properties files only:
    //      - Mill_en_CA.properties
    //      - Mill_en.properties
    //      - Mill.properties (default bundle)
    ResourceBundle rb = ResourceBundle.getBundle("localisation.Mill", localeCA);
    // Because we are locked into a hierarchy (see above), this is why "name" below
    // comes up with "Some Mill" even though the "name" key is in the default locale
    // as well i.e. Mill_en_IE.properties
    System.out.println(rb.getString("name"));
    System.out.println("------------------------");
  }

  public static void ignoreAmericanBundle() {
    Locale.setDefault(new Locale("en", "IE"));
    Locale localeUS = new Locale("en", "US");

    ResourceBundle rb = ResourceBundle.getBundle("localisation.Mill", localeUS);
    System.out.println(rb.getString("open"));
    System.out.println(rb.getString("name"));
    System.out.println("------------------------");
  }

  public static void usingDefaultLocale() {
    Locale.setDefault(new Locale("en", "IE"));
    Locale localeFR = new Locale("fr", "FR");

    ResourceBundle rb = ResourceBundle.getBundle("localisation.Mill", localeFR);
    System.out.println(rb.getString("open"));
    System.out.println(rb.getString("name"));
    System.out.println("------------------------");
  }
}
