import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class p624CD {
    static ArrayList<Integer> durations;
    static boolean[]  visited;
    static int maxDuration;
    static int answer;
    static int  output;
    static int  n;

    public static void main(String[] args) {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));


        while (in.hasNext ()){
            maxDuration=in.nextInt ();
             n=in.nextInt ();
             answer=0;output=0;
             durations=new ArrayList<> (n);
             visited=new boolean[n];
            for (int i = 0; i < n; i++) {
                durations.add(in.nextInt ());
            }
            backtrack (0,0,0);
            int counter=1;
            for (int i = 0; i < n; i++) {
                if(((counter)&output)!=0)
                    out.append (durations.get(i)+" ");
                counter<<=1;
            }
            out.append ("sum:"+answer+"\n");
        }

        out.flush();
        out.close();

    }
     static void backtrack(int dura,int tracks,int x){
        if(dura>maxDuration) return;

        if(answer<dura){
            answer=dura;
            output=tracks;
        }
        for (int i = x; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                backtrack (dura+durations.get(i),tracks|(1<<i),i+1);
                visited[i]=false;
            }
        }
    }
}
