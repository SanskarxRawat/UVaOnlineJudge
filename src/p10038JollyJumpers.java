import java.io.*;
import java.util.Scanner;

public class p10038JollyJumpers {
    public static void main(String[] args)throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        while(in.hasNextInt ()){
            int n=in.nextInt ();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=in.nextInt ();
            }
            if(n==1) {
                out.append ("Jolly\n");
                continue;
            }
            boolean[] check=new boolean[n-1];
            for (int i = 0; i < n-1; i++) {
                int value=Math.abs (arr[i]-arr[i+1])-1;
                if(value>=0 && value<check.length) check[value]=true;
            }
            boolean flag=true;
            for(boolean c:check){
                flag=flag&&c;
            }
            out.append (flag?"Jolly\n":"Not jolly\n");
        }


        out.flush ();
        out.close ();
    }
}
