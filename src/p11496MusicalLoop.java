import java.io.*;
import java.util.StringTokenizer;

public class p11496MusicalLoop {
    public static void main(String[] args)throws Throwable{

        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while(true){
            int  n=Integer.parseInt (in.readLine ());
            if(n==0) break;
            StringTokenizer  st=new StringTokenizer (in.readLine ()," ");
            int[] notes=new int[n+2];
            for (int i = 0; i < n; i++) {
                notes[i]=Integer.parseInt (st.nextToken ());
            }
            int  counter=0;
            notes[n]=notes[0];
            notes[n+1]=notes[1];
            boolean up=false;
            if(notes[1]>notes[0]) up=true;

            for (int i = 2; i <n+2; i++) {
               if(up && notes[i]<notes[i-1]){
                   counter++;
                   up=false;
               }
               else if(!up && notes[i]>notes[i-1]){
                   counter++;
                   up=true;
               }
            }
            out.println (counter);

        }
        out.flush ();
        out.close ();

    }
}
