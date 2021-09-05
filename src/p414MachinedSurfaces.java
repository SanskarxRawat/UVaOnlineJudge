import java.io.*;
import java.util.ArrayList;

public class p414MachinedSurfaces {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out =new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while(true){

            int N=Integer.parseInt (in.readLine ());
            if(N==0) break;
            ArrayList<Long> spaces=new ArrayList<> ();
            long min=-1;
            for (int i = 0; i <N ; i++) {
                long space=0;
                String line=in.readLine ();
                space=line.chars ().filter(ch->ch!='X').count ();
                spaces.add(i,space);
                min=(space<min||min==-1)?space:min;
            }
            long total=0;
            for (int i = 0; i < N; i++) {
                total+=spaces.get(i)-min;
            }
            out.println (total);
        }
        out.flush ();
        out.close ();

    }

}
