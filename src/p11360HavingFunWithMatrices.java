import java.io.*;
import java.util.StringTokenizer;

public class p11360HavingFunWithMatrices{
    static int[][] matrix;

    public static void main(String[] args)throws Throwable{

        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        int test=Integer.parseInt (in.readLine ());
        int cases=1;

        while (test-->0){
            int n=Integer.parseInt (in.readLine ());
            matrix=new int[n][n];

            for (int i = 0; i < n; i++) {
                String line=in.readLine ();
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=Integer.parseInt (String.valueOf (line.charAt (j)));
                }
            }
            int m=Integer.parseInt (in.readLine ());
            StringTokenizer  st;
            int inc=0;
            for (int i = 0; i < m; i++) {
                st=new StringTokenizer (in.readLine ()," ");
                String s=st.nextToken ();
                if(s.equals ("transpose")){
                    transpose ();
                }
                else if(s.equals ("dec")){
                    inc--;

                }
                else if(s.equals ("inc")){
                    inc++;
                }
                else{
                    int x=Integer.parseInt (st.nextToken ());
                    int y=Integer.parseInt (st.nextToken ());
                    switch (s) {
                        case "row":
                            swapR (x, y);
                            break;
                        case "col":
                            swapC (x, y);
                            break;
                    }
                }


            }
            out.format ("Case #%d\n",cases++);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print ((matrix[i][j]+inc+10)%10);

                }
                out.println ();

            }
            out.println ();

        }
        out.flush ();
        out.close ();

    }

    public static void swapR(int a,int b){
        for (int i = 0; i < matrix.length; i++) {
            int temp=matrix[a-1][i];
            matrix[a-1][i]=matrix[b-1][i];
            matrix[b-1][i]=temp;
        }
    }
    public static void swapC(int a,int b) {
        for (int i = 0; i < matrix.length; i++) {

            int temp=matrix[i][a-1];
            matrix[i][a-1]=matrix[i][b-1];
            matrix[i][b-1]=temp;

        }
    }
    static void transpose(){

        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

}