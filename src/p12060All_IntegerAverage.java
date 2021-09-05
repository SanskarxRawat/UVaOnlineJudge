import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
import  java.lang.StrictMath;
public class p12060All_IntegerAverage {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        int cases=1;
            while(test-->0){
                StringTokenizer st=new StringTokenizer (in.readLine ()," ");
//                if(st.equals ("0")) break;
                double avg=0.0;
                int sum=0,N=Integer.parseInt (st.nextToken ());
                while(st.hasMoreTokens ()){
                   sum+=Integer.parseInt (st.nextToken ());
                }
                avg=(double) sum/N;

                out.print("Case "+cases++ +":\n");
                if(sum%N==0){
                    if(sum<0) out.print("- ");
                out.print(StrictMath.abs (sum/N)+"\n");
                }

                else{
                    boolean negative=sum<0;
                    sum=StrictMath.abs (sum);
                    int preced=sum/N;
                    int length=numDigits (preced);
                    sum=sum%N;

                    int GCD=gcd (sum,N);
                    int num=sum/GCD,deno=N/GCD;
                    int longest=StrictMath.max (numDigits (num),numDigits (deno));

                    if(StrictMath.abs(avg)>1){
                        for(int i=0;i<length;i++) out.print(" ");
                        out.println(num);
                        out.print (preced);
                        for (int i = 0; i < longest; i++) out.print("-");
                        out.println ();
                        for(int i=0;i<length;i++) out.print(" ");
                        out.print(deno);
                        out.println ();
                    }
                    else if(StrictMath.abs(avg)<1){
                        for(int i=0;i<length;i++) out.print(" ");
                        out.println(num);
                        for (int i = 0; i < longest; i++) out.print("-");
                        out.println ();
                        for(int i=0;i<length;i++) out.print(" ");
                        out.print(deno);
                        out.println ();
                    }

                }



            }
            out.flush ();
            out.close ();

    }
    public static int numDigits(int num){
        int count=0;
        while(num>0){
            num/=10;
            ++count;
        }
        return count;
    }
    public static void printForPositive(int num,int deno,int lenght,int longest){

    }

    public static int gcd(int a,int b){
        BigInteger b1=new BigInteger (String.valueOf (a));
        BigInteger b2=new BigInteger (String.valueOf (b));
        return b1.gcd(b2).intValue ();
    }
}
