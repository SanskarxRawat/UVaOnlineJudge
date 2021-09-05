import java.io.*;
import java.util.StringTokenizer;

/*
@author : sanskarXrawat
@date   : 5/18/2021
@time   : 1:23 PM
 */
public class p11565SimpleEquations {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        while(test-->0){
            StringTokenizer  st=new StringTokenizer (in.readLine ()," ");
            int A=Integer.parseInt (st.nextToken ());
            int B=Integer.parseInt (st.nextToken ());
            int C=Integer.parseInt (st.nextToken ());
            boolean flag=false;
            for (int x = -100; x <= 100 && !flag; x++) {
                for (int y = x+1; y <=100 && !flag ; y++) {
                    for (int z = y+1; z<=100 && !flag; z++) {
                        if(x+y+z==A && x*y*z==B && (x*x)+(y*y)+(z*z)==C){
                            flag=true;
                            out.print(x+" "+y+" "+z+"\n");
                        }

                    }

                }

            }
            if(!flag) out.print ("No solution.\n");
        }
        out.flush ();
        out.close ();

    }
}
