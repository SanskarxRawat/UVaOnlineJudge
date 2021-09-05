import java.io.*;
import java.util.StringTokenizer;

public class p10324_ZerosandOnes {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases=1;
        while(in.ready()){
            String s= in.readLine();
            int n=Integer.parseInt(in.readLine());
            out.append("Case "+cases++ +":\n");
            while(n-->0){
                StringTokenizer tokenizer=new StringTokenizer(in.readLine());
                int i=Integer.parseInt(tokenizer.nextToken());
                int j=Integer.parseInt(tokenizer.nextToken());
                out.append(check(Math.min(i,j),Math.max(i,j),s)?"Yes\n":"No\n");
            }

        }
        out.flush();
        out.close();
    }
    public static boolean check(int a,int b,String s){
        char x=s.charAt(a);
        for (int i = a+1; i <=b ; i++) {
            if(s.charAt(i)!=x) return false;
            
        }
        return true;
    }
}
