
import java.io.*;
import java.util.StringTokenizer;


public class p11349SymmetricMatrix{
    static long[][] matrix;
    static int N=0;
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        int test=Integer.parseInt (in.readLine ());
        int cases=1;
        StringTokenizer st;
        while (test-->0){
            st=new StringTokenizer (in.readLine ()," ");
            st.nextToken ();st.nextToken ();N=Integer.parseInt (st.nextToken ());
            matrix=new long[N][N];
            boolean flag=true;
            for (int i = 0; i < N; i++) {
                st=new StringTokenizer (in.readLine ()," ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j]=Long.parseLong (st.nextToken ());
                    if(matrix[i][j]<0) flag=false;
                }
            }
            out.printf ("Test #%d: %s.\n",cases++,(flag&&check ())?"Symmetric":"Non-symmetric");
        }

        out.flush ();
        out.close ();
    }

    public static boolean check(){
        int x,y;
        for (int i = 0; i < (N+1)>>1; i++) {
            for (int j = 0; j < N; j++) {
                 x=N-1-i;
                 y=N-1-j;
                 if(matrix[x][y]!=matrix[i][j])
                     return false;

            }

        }
        return true;
    }
}