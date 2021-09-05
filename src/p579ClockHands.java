import java.io.*;
import java.util.StringTokenizer;

public class p579ClockHands {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while(in.ready ()){
            StringTokenizer st=new StringTokenizer (in.readLine (),":");
            int hours=Integer.parseInt (st.nextToken ());
            int mins=Integer.parseInt (st.nextToken ());
            if(hours==0 && mins==0) break;
             double angle=Math.abs(0.5* (60 * hours - 11 * mins));
             out.printf("%.3f\n",angle>180?(360-angle):angle);
        }
        out.flush ();
        out.close ();

    }
}
