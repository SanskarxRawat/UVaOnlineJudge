import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class p893Y3KProblem {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while (in.ready ()){
            StringTokenizer st=new StringTokenizer (in.readLine ());
            int N=Integer.parseInt (st.nextToken ());
            int date=Integer.parseInt (st.nextToken ());
            int month=Integer.parseInt (st.nextToken ());
            int year=Integer.parseInt (st.nextToken ());
            if(N==0 && date==0 && month==0 && year==0) break;
            GregorianCalendar calendar=new GregorianCalendar (year,month-1,date);
            calendar.add (Calendar.DATE,N);
            out.println (calendar.get (Calendar.DATE)+" "+(calendar.get (Calendar.MONTH)+1)+" "+calendar.get(Calendar.YEAR));
        }
        out.flush ();
        out.close ();

    }
}
