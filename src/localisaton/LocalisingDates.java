package localisaton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalisingDates {
  public static void main(String[] args){
    Locale locUS = Locale.US;
    Locale locFrench = new Locale("fr", "FR");
    Locale locGermany = Locale.GERMANY;

    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt);

    DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    // Using the Unites States locale (en_US)
    System.out.println(dateMediumStyle.withLocale(locUS).format(ldt));
    // Using the french locale
    System.out.println(dateMediumStyle.withLocale(locFrench).format(ldt));

    DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
    // Using the Unites States locale (en_US)
    System.out.println(timeShortStyle.withLocale(locUS).format(ldt));
    // Using the German locale
    System.out.println(timeShortStyle.withLocale(locGermany).format(ldt));

    DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    // Using the default locale (en_PH)
    System.out.println(dateTimeShortStyle.format(ldt));
    // Using the United States locale (en_US)
    System.out.println(dateTimeShortStyle.withLocale(locUS).format(ldt));
  }
}
