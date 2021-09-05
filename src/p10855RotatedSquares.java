import java.io.*;

public class p10855RotatedSquares {


    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        while (true){
            String[] line=in.readLine ().split (" ");
            int N=Integer.parseInt (line[0]);
            int n=Integer.parseInt (line[1]);
            if(N+n==0) break;
             char[][] big=new char[N][N];
             char[][] small=new char[n][n];
            for (int i = 0; i < N; i++) {
                String s=in.readLine ();
                for (int j = 0; j < N; j++) {
                    big[i][j]=s.charAt (j);
                }
            }
            for (int i = 0; i < n; i++) {
                String s=in.readLine ();
                for (int j = 0; j < n; j++) {
                    small[i][j]=s.charAt (j);
                }
            }
            int[] ans=new int[4];int  counter=0;

            do{
                for (int i = 0; i <=N-n; i++) {
                    for (int j = 0; j <=N-n; j++) {
                        if(checkEqual (big,small,i,j))
                            ans[counter]++;

                    }

                }
                small=rotate90 (small);

            }while (++counter<4);

           out.append (ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[3]+"\n");



        }
        out.flush ();
        out.close ();

    }
    static char[][] rotate90(char[][] toRotate){
        char[][] rotated=new char[toRotate.length][toRotate.length];

        for (int i = 0; i < toRotate.length; i++) {
            for (int j = 0; j < toRotate.length; j++) {
                rotated[i][j]=toRotate[toRotate.length-j-1][i];

            }

        }
        return rotated;

    }
    static boolean checkEqual(char[][] big,char[][] small,int x,int y){
        for (int i = 0; i < small.length; i++) {
            for (int j = 0; j < small.length; j++) {
                if(big[i+x][j+y]!=small[i][j])
                    return false;

            }

        }
        return true;
    }

}
