
import java.util.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Kalenderausgabe_verbessert {
  public static void main(String[] args) {

    GregorianCalendar cal = new GregorianCalendar();

    int today = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH);

    cal.set(Calendar.DAY_OF_MONTH,1);
    int weekday = cal.get(Calendar.DAY_OF_WEEK);

    System.out.println("So  Mo  Di  Mi  Do  Fr  Sa");

    //bis zum Ersten des Monats vorrücken
    for(int i=Calendar.SUNDAY;i<weekday;i++)
      System.out.print("    ");

    //Schleife zum Ausgeben des Kalenders
    do
    {
      int day = cal.get(Calendar.DAY_OF_MONTH);

      if (day < 10)
        System.out.print(" ");
      System.out.print(day);

      if (day == today)
        System.out.print("* ");
      else
        System.out.print("  ");

      if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        System.out.println();

      cal.add(Calendar.DAY_OF_MONTH,1);

    }
    while(month ==cal.get(Calendar.MONTH));

  }
}