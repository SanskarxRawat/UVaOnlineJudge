import java.io.*;
import java.util.StringTokenizer;

public class p665FalseCoin {
    static BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
    static PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
    static StringTokenizer st=new StringTokenizer ("");

    public static void main(String[] args)throws Throwable {

        int  M=Integer.parseInt (in.readLine ());
        in.readLine ();
        while (M-->0){
            String[] line=in.readLine ().trim ().split (" ");
            int  N=Integer.parseInt (line[0]); int K=Integer.parseInt (line[1]);
            boolean[] check=new boolean[N+1];
            for (int i = 0; i < K; i++) {
                int x=Integer.parseInt (next ());
                int[] coins=new int[x*2];
                for (int j = 0; j < 2*x; j++) {
                    coins[j]=Integer.parseInt (next ());
                }
                String s=next ();
                if(s.equals ("=")){
                    for (int j = 0; j < coins.length; j++) {
                        check[coins[j]]=true;
                        
                    }
                }

            }
            int index=-1,count=0;

            for (int i = 1; i <=N; i++) {
                if(!check[i]){
                    index=i;
                    count++;
                }
                
            }
            out.println (count==1?index+"\n":"0\n");
            in.readLine ();


        }
        out.flush ();
        out.close ();

    }

    public static String next(){
        while (st==null || !st.hasMoreTokens ()){
            try{
                st=new StringTokenizer (in.readLine ());
            }
            catch (IOException e){
                throw new RuntimeException (e);
            }
        }
        return st.nextToken ();
    }
}
