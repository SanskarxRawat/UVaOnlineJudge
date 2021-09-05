import java.io.*;
import java.util.Scanner;

public class p11764_JumpingMario {
    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases=1;
        int test=in.nextInt();
        while(test-->0){
            int[] jumps;
            int high=0,low=0;
            int N=in.nextInt();
            jumps=new int[N];
            for (int i = 0; i < N; i++) jumps[i]=in.nextInt();
            for (int i = 1; i < N; i++) {
                if(jumps[i-1]<jumps[i]) high++;
                else if(jumps[i-1]>jumps[i]) low++;
            }
            out.append("Case "+cases++ +": "+high+" "+low+"\n");

        }
        out.flush();
        out.close();
    }
}
