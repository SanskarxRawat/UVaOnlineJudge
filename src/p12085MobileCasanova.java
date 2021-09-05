import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class p12085MobileCasanova {
    public static void main(String[] args) throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        int cases=1;
        StringBuffer buffer=new StringBuffer ();
        while(true){
            int N=in.nextInt ();
            if(N==0) break;
            buffer.append ("Case ").append (cases++).append (":").append ("\n");
            ArrayList<Integer> arr=new ArrayList<> (N);
            for (int i = 0; i < N; i++) {
                arr.add (in.nextInt ());

            }
            buffer.append (solve (arr)).append ("\n");

        }
        out.print(buffer.toString ());
        out.flush ();
        out.close ();

    }
    public static String solve(ArrayList<Integer> array){
        if(array.size ()==0) return "";
        StringBuilder builder=new StringBuilder ();
        boolean first=false;
        int begin=array.get(0);
        builder.append ("0").append (array.get(0));
        for (int i = 1; i <array.size () ; i++) {
            if(array.get(i)-array.get(i-1)==1){
                first=true;
                continue;
            }
            else{
                if(first){
                    builder.append (difference(begin+"",array.get(i-1)+""));
                }
                else {
                    builder.append ("\n");
                }
                first=false;
                begin=array.get(i);
                builder.append ("0").append (array.get (i));
            }

        }
        if(first){
            builder.append (difference (begin+"",array.get (array.size ()-1)+""));
        }
        else{
            builder.append ("\n");
        }
        return builder.toString ();

    }
    public static String difference(String x,String y){
        int index=0;
        for (int i = 0; i < x.length (); i++) {
            if(x.charAt (i)!=y.charAt (i)){
                index=i;
                break;
            }

        }
        return "-"+y.substring (index)+"\n";
    }
}
