import java.io.*;

import java.util.Arrays;


public class p482PermutationArrays {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int n=Integer.parseInt (in.readLine ());
        in.readLine ();
        while(n-->0){
            int[] index= Arrays.stream (in.readLine ().split (" ")).mapToInt (Integer::parseInt).toArray ();
            String[] values=in.readLine ().split (" ");
            String[] answer=new String[values.length];
            for (int i = 0; i < index.length; i++) {
                answer[index[i]-1]=values[i];
            }
            for(String x:answer){
                out.println (x);
            }
            if(n!=0){
                out.println ();
                in.readLine ();
            }

        }
        out.flush ();
        out.close ();
    }
}
