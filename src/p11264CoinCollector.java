
import java.io.*;
import java.util.StringTokenizer;

public class p11264CoinCollector {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());
        while(tc-->0)
        {
            int n = Integer.parseInt(in.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 0; i < n; i++)
                coins[i] = Integer.parseInt(st.nextToken());
            int currentSum = 0;
            int index = 1;
            for(int i = 0; i < n; i++)
            {
                if(i>0){
                    if(currentSum>=coins[i]){
                        currentSum-=coins[i-1];
                        currentSum+=coins[i];
                    }
                    else{
                        currentSum+=coins[i];
                        index++;
                    }
                }
                else{
                    currentSum=coins[i];
                }



            }
            out.println (index);
        }



        out.flush ();
        out.close ();

    }
}