import java.io.*;
import java.util.Scanner;

public class p541ErrorCorrection {
    public static void main(String[] args)throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));

        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while (true){
            int N=in.nextInt ();

            if(N==0) break;
            int[] c=new int[N];
            int[] r=new int[N];
            int[][] array=new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    array[i][j] = in.nextInt ();
                    r[i]+=array[i][j];
                    c[j]+=array[i][j];
                }
            }
            int indexA=0,indexB=0,C=0,R=0;
            for (int i = 0; i < N; i++) {
                if(r[i]%2!=0){
                    R++;
                    indexA=i+1;
                }
                if(c[i]%2!=0){
                    C++;
                    indexB=i+1;
                }

            }
            if(C==R){
                if(C==0)
                    out.append ("OK\n");
                    if(C==1)
                        out.format ("Change bit (%d,%d)\n",indexA,indexB);
            }
            else
                out.append ("Corrupt\n");
        }
        out.flush ();
        out.close ();

    }
}
