package localisaton;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;

public class SettingLocaleCategories {
  public static void main(String[] args){
    double n = 77_000.11;
    Locale locFrench = new Locale("fr", "FR");

    Locale defaultLocale = Locale.getDefault();
    System.out.println(defaultLocale.getDisplayName());
    System.out.println(defaultLocale.getDisplayLanguage());
    System.out.println(defaultLocale.getDisplayCountry());
    System.out.println(NumberFormat.getInstance().format(n));

    Locale.setDefault(Category.DISPLAY, locFrench);
    System.out.println("\nDISPLAY changed: " + defaultLocale.getDisplayName());
    System.out.println("DISPLAY changed: " + defaultLocale.getDisplayLanguage());
    System.out.println("DISPLAY changed: " + defaultLocale.getDisplayCountry());
    System.out.println("DISPLAY changed: " + NumberFormat.getInstance().format(n));

    Locale.setDefault(Locale.Category.FORMAT, locFrench);
    System.out.println("FORMAT changed: \t" + NumberFormat.getInstance().format(n));
  }
}
