/*
@author : sanskarXrawat
@date   : 5/17/2021
@time   : 1:54 PM
 */
import java.io.*;
import java.util.ArrayList;

public class p10487ClosestSums {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int cases=1;
        while(true){
            int  N=Integer.parseInt (in.readLine ());
            if(N==0) break;
            ArrayList<Integer> numbers=new ArrayList<> ();
            for (int i = 0; i < N; i++) numbers.add (Integer.parseInt (in.readLine ()));
            out.append ("Case "+cases++ +":\n");
            int m=Integer.parseInt (in.readLine ());
            for (int i = 0; i <m ; i++) {
                int query=Integer.parseInt (in.readLine ());
                int diff=Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        int  currentDiff=query-(numbers.get (j)+numbers.get(k));
                        if(StrictMath.abs (currentDiff)<StrictMath.abs(diff))
                            diff=currentDiff;

                    }

                }
                out.append ("Closest sum to "+query+" is "+(query-diff)+".\n");

            }



        }

        out.flush ();
        out.close ();

    }
}
