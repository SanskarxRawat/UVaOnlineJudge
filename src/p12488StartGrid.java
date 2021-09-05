/*
@author : sanskarXrawat
@date   : 5/18/2021
@time   : 12:54 PM
 */

import java.io.*;
import java.util.StringTokenizer;

public class p12488StartGrid {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while(in.ready ()){
            int N=Integer.parseInt (in.readLine ());
            int[] grid=new int[N];
            int[] finish=new int[N];
            StringTokenizer g=new StringTokenizer (in.readLine ()," ");
            StringTokenizer f=new StringTokenizer (in.readLine ()," ");
            for (int i = 0; i < N; i++) grid[i]=Integer.parseInt (g.nextToken ());
            for (int j = 0; j <N ; j++) finish[j]= Integer.parseInt (f.nextToken ());
            int counter=0,i,j;
            for (i = 0; i < grid.length; i++) {
                for (j = i; j < grid.length; j++) {
                    if(finish[i]==grid[j]) break;
                }
                for (int k=j; k>i ; k--) {
                    grid[k]=grid[k-1];
                    counter++;
                }

            }
            out.println (counter);
        }
        out.flush();
        out.close();

    }
}
