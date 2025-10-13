package localisation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalisingNumbers {
  public static void main(String[] args) {
    formatNumbers();
    formatCurrencies();
    parseNumbers();
    parseCurrencies();
    customFormats();
  }

  public static void formatNumbers() {
    // format: number --> String
    double n = 77_000.11;
    System.out.println(NumberFormat.getInstance().format(n));
    System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n));
    System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).format(n));
    System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).format(n));
  }

  public static void formatCurrencies() {
    // format: number --> String
    double n = 23.22;
    System.out.println(NumberFormat.getCurrencyInstance().format(n));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).format(n));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(n));
  }

  public static void parseNumbers() {
    String unitedStatesNumber = "77,000.11",
        italianNumber = "77.000,11",
        frenchNumber = "77 000,11";
    try {
      System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
      System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
      System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
  }

  public static void parseCurrencies() {
    // parse: String --> number
    String phCurrency = "₱23.22",
        unitedStatesCurrency = "$23.22",
        italianCurrency = "23,22 €",
        unitedKingdomCurrency = "£23.22";

    try {
      System.out.println(NumberFormat.getCurrencyInstance().parse(phCurrency));
      System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(unitedStatesCurrency));
//      System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).parse(italianCurrency));
      System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(unitedKingdomCurrency));
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
  }

  public static void customFormats() {
    // DecimalFormat specifies the custom format
    //      # means leave it out if we don't have a digit in this position
    //      0 means insert 0 if we don't have a digit in this position
    double n = 77_000.17;
    System.out.println(new DecimalFormat("€#,###,###.#").format(n));
    System.out.println(new DecimalFormat("€0,000,000.0").format(n));
  }
}
