import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class p11947CancerScorpio {
    public static void main(String[] args) throws Throwable{
        final int[] DATES={21, 20, 21, 21, 22, 22, 23, 22, 24, 24, 23, 23};
        final String[] ZODIAC={"aquarius", "pisces", "aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn"};


        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        int cases=1;
        while(test-->0){
            String s=in.readLine ();
            int  month=Integer.parseInt(s.substring (0,2));
            int  date=Integer.parseInt(s.substring (2,4));
            int  year=Integer.parseInt(s.substring (4));
            GregorianCalendar calendar=new GregorianCalendar (year,month-1,date);
            calendar.add (Calendar.WEEK_OF_YEAR,40);
            month=calendar.get (Calendar.MONTH);
            date=calendar.get (Calendar.DATE);
            out.printf("%d %02d/%02d/%04d ",cases++ ,(month+1),date,calendar.get(Calendar.YEAR));
            if(DATES[month]>date) --month;
            out.println (ZODIAC[month<0?11:month]);
        }
        out.flush ();
        out.close ();
    }
}
