import java.io.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class p12019DoomDayAlgorithm {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        Locale locale=new Locale ("en", "USA");
        DateFormatSymbols symbols = new DateFormatSymbols (locale);
        final String[] DAYS_NAME = symbols.getWeekdays();
        while(test-->0){
            StringTokenizer st=new StringTokenizer (in.readLine ()," ");
            int M=Integer.parseInt (st.nextToken());
            int D=Integer.parseInt (st.nextToken ());
            GregorianCalendar calendar=new GregorianCalendar (2011,M-1,D);
            out.println (DAYS_NAME[calendar.get(Calendar.DAY_OF_WEEK)]);

        }
        out.flush ();
        out.close ();

    }

}
