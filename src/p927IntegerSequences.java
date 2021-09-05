import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p927IntegerSequences {
    public static void main(String[] args) throws Throwable {
        Scanner in=new Scanner (System.in);
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int C=in.nextInt ();
        while(C-->0){
            int degrees=in.nextInt ();
            ArrayList<Integer> coefficients=new ArrayList<> (degrees+1);
            for (int i = 0; i < degrees+1; i++) {
                coefficients.add (in.nextInt ());
            }
            int d=0,k=0,n=1,counter=0;
            d=in.nextInt ();k= in.nextInt ();
            while(true){
                long a=0;
                for (int i = 0; i < degrees+1; i++) {
                    a+=coefficients.get (i)*power(n,i);

                }
                counter+=n*d;
                if(counter>=k){
                    out.println (a);
                    break;
                }
                ++n;

            }
        }
        out.flush ();
        out.close ();
    }
    public static long power(int base,int exponent){
        long ans=1;
        while(exponent-->0){
            ans*=base;
        }
        return ans;
    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(FileReader r){    br = new BufferedReader(r);}

        public String next() throws Throwable
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine(), " |(|)|:");
            return st.nextToken();
        }

        public int nextInt() throws Throwable {return Integer.parseInt(next());}

        boolean ready() throws Throwable { return br.ready(); }

        boolean hasNext() throws Throwable
        {
            while (br.ready() && (st == null || !st.hasMoreTokens()))
                st = new StringTokenizer(br.readLine(), " |(|)|:");
            return st != null && st.hasMoreTokens();
        }
    }
}



