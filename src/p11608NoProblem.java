import java.io.*;
import java.util.StringTokenizer;

public class p11608NoProblem {
    public static void main(String[] args)throws Throwable {
        BufferedReader  in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int cases=1;
        while (true){
            int S=Integer.parseInt (in.readLine ());
            if(S<0) break;
            int[] created=new int[12];
            int[] required=new int[12];
            StringTokenizer st=new StringTokenizer (in.readLine ()," ");
            for (int i = 0; i < 12; i++) {
                created[i]=Integer.parseInt (st.nextToken ());
            }
            st=new StringTokenizer (in.readLine ()," ");
            for (int i = 0; i < 12; i++) {
                required[i]=Integer.parseInt (st.nextToken ());
            }

            out.append ("Case "+cases++ +":\n");
            int current=S;
            for (int i = 0; i < 12; i++) {
                if(current<required[i]){
                    out.append ("No problem. :(\n");
                }
                else{
                    current-=required[i];
                    out.append ("No problem! :D\n");
                }
                current+=created[i];

            }

        }
        out.flush ();
        out.close ();

    }
}
