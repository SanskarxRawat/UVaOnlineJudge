import java.io.*;
import static java.lang.Math.sqrt;


public class p11221MagicSquarePalindromes {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=Integer.parseInt(in.readLine());
        int cases=1;
        char[][] matrix;
        while(test-->0){
            String s=in.readLine().replaceAll("[\\p{Punct}\\p{Blank}]","");
            int K=(int) sqrt(s.length());
            if((K*K)!=s.length()){
                out.print("Case #"+cases++ +":\n"+"No magic :(\n");
                continue;
            }
            int counter=0;
            matrix=new char[K][K];
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    matrix[i][j]=s.charAt(counter++);
                }
            }
            out.print("Case #"+cases++ +":" +"\n");

            out.print((readingOne(K,matrix).toString().equals(s) &&
                       readingTwo(K,matrix).toString().equals(s) &&
                       readingOne(K,matrix).reverse().toString().equals(s) &&
                       readingTwo(K,matrix).reverse().toString().equals(s)?
                       K+"\n":"No magic :(\n"
                    ));
        }
        out.flush();
        out.close();

    }
    public static StringBuilder readingOne(int K,char[][] matrix){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                sb.append(matrix[i][j]);
            }
            
        }
        return sb;
    }
    public static StringBuilder readingTwo(int K,char[][] matrix){
        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < K; j++) {
            for (int i = 0; i < K; i++) {
                sb.append(matrix[i][j]);
            }

        }
        return sb;
    }


}
