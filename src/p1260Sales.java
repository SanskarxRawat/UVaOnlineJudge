import java.io.*;
import java.util.ArrayList;

public class p1260Sales {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());

        while (test-->0){
            int N=Integer.parseInt (in.readLine ());

            ArrayList<Integer> sales=new ArrayList<> ();
            String[] line=in.readLine ().split (" ");
            for (int i = 0; i < N; i++) {
                sales.add (Integer.parseInt (line[i]));
            }
            int sum=0;
            for (int i = 1; i < N; i++) {
                int counter=0;
                for (int j = 0; j <i ; j++) {
                    if(sales.get(j)<=sales.get(i)){
                        counter++;

                    }
                }
                sum+=counter;

            }
            out.print (sum+"\n");

        }

        out.flush ();
        out.close ();

    }
}
