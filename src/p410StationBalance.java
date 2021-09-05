import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p410StationBalance {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));



        int cases=1;
        DecimalFormat f=new DecimalFormat ("0.00000");

        while (in.ready ()){
            StringTokenizer st=new StringTokenizer (in.readLine ()," ");
            int c=Integer.parseInt (st.nextToken ());
            int s=Integer.parseInt (st.nextToken ());
            int[] arr=new int[c<<1];
            st=new StringTokenizer (in.readLine ()," ");

            int sum = 0;
            double imbalance = 0;
            for (int i = 0; i < s; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            int[] arr2 = arr.clone();
            Arrays.sort(arr2);
            out.append("Set #"+cases++ +"\n");
            double a = sum*1.0/c;
            for (int i = 0; i < c; i++)
            {
                int x = arr2[i],y = arr2[2*c-1-i];
                out.append(" "+i+":");
                if(x==0 || y==0)
                {
                    if(x!=0)
                        out.append(" "+x);
                    if(y!=0)
                        out.append(" "+y);
                }
                else
                    out.append(" "+x+" "+y);
                imbalance += Math.abs((x+y)-a);
                out.append("\n");
            }
            out.append("IMBALANCE = "+f.format(imbalance)+"\n\n");
        }
        out.flush ();
        out.close ();

    }
}
