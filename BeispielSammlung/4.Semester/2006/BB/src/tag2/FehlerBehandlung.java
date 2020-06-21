package tag2;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FehlerBehandlung {

    void doSomething() throws ParseException, java.io.IOException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date d1 = sdf.parse("10:15");

    }

    public static void main(String[] args)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

          try {
              Date d1 = sdf.parse("10:15");

              System.out.println("Funktioniert");

              // code ...

          } catch (ParseException ex) {
              ex.printStackTrace();
              System.exit(0);
          }
    }
}
