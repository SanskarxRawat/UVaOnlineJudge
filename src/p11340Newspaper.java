import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class p11340Newspaper {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());

        while (test-->0){
            int k=Integer.parseInt (in.readLine ());
            StringTokenizer st;
            int[] hash=new int[128];
            Arrays.fill(hash,-1);
            for (int i = 0; i < k; i++) {
                st=new StringTokenizer (in.readLine ()," ");
                hash[st.nextToken ().charAt (0)]=Integer.parseInt (st.nextToken ());

            }
            int m=Integer.parseInt (in.readLine ());
            int money=0;
            for (int i = 0; i < m; i++) {
                String line=in.readLine ();
                for (int j = 0; j < line.length (); j++) {
                    int c=(int) line.charAt (j);
                    if(c<0 || c>=128|| hash[c]<0)
                        money+=0;
                    else
                        money+=hash[c];
                }
            }
            if(money%100<10){
                out.format ("%d.0%d$\n",money/100,money%100);
            }
            else{
                out.format ("%d.%d$\n",money/100,money%100);
            }

        }
        out.flush ();
        out.close ();

    }
}
