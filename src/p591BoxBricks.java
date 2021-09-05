import java.io.*;
import java.util.Arrays;

public class p591BoxBricks {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int cases=1;

        while(true){
            int n=Integer.parseInt (in.readLine ());
            if(n==0) break;
            int[] array= Arrays.stream (in.readLine ().trim ().split (" ")).mapToInt (Integer::parseInt).toArray ();
            int average= Arrays.stream(array).sum ()/n;
            Arrays.sort (array);
            int result=0,current=0;
            for (int i = n-1; i >=0 ; i--) {
                if(array[i]>=average){
                    current+=array[i]-average;
                    result+=array[i]-average;
                }
                else{
                    current-=average-array[i];
                }

            }
            out.append ("Set #"+cases+++"\n"+"The minimum number of moves is "+result+".\n\n");




        }
        out.flush ();
        out.close ();

    }
}
