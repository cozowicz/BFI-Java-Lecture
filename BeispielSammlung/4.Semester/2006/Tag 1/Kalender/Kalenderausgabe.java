
import java.util.*;
import java.lang.*;
import java.text.*;
/**
 * <p>Title: Kalender
 * <p>Description: gibt einen Kalender für diesen Monat aus
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Clemens Klee
 * @version 1.0
 */

public class Kalenderausgabe {
  public static void main(String[] args) {

    int[][] daysofmonth = new int[5][7];
    int count=0;
    GregorianCalendar cal = new GregorianCalendar();

    int heute=0;
    heute=cal.get(Calendar.DAY_OF_MONTH);
    int erstertag=0;

    for(int i=heute;i>0;i--){
      cal.roll(cal.DAY_OF_MONTH, false);
      erstertag=i;
    }

    GregorianCalendar cal2 = new GregorianCalendar(cal.get(Calendar.YEAR),
                                                   cal.get(Calendar.MONTH),erstertag);

    int dayofweek=cal2.get(Calendar.DAY_OF_WEEK)-1;
    for(int i=cal2.get(Calendar.WEEK_OF_MONTH)-1;i<5;i++)
    {
      for(int j=dayofweek;j<7;j++)
      {
        daysofmonth[i][j] = (cal2.get(Calendar.DAY_OF_MONTH))+count;
        count++;
        dayofweek=0;
        if(count==cal2.getActualMaximum(Calendar.DAY_OF_MONTH))
          break;
      }
    }

System.out.println("So  Mo  Di  Mi  Do  Fr  Sa");

    for(int i=0;i<5;i++)
    {
      for(int j=0;j<7;j++)
      {
        if(daysofmonth[i][j]==heute){
          if (daysofmonth[i][j] < 10)
           {
             System.out.print(daysofmonth[i][j] + "*  ");
           }
          else if(daysofmonth[i][j]>=10){
            System.out.print(daysofmonth[i][j]+"* ");
          }
         }
        else if(daysofmonth[i][j]==0)
        {
         System.out.print("    ");
        }

        else if(daysofmonth[i][j]<10)
        {
          System.out.print(daysofmonth[i][j] + "   ");
        }
        else if(daysofmonth[i][j]>=10)
        {
          System.out.print(daysofmonth[i][j]+ "  ");
        }
      }
      System.out.println();
    }

  }
}