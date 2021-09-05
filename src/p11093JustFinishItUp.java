import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class p11093JustFinishItUp {
    public static void main(String[] args)throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=in.nextInt ();
        int cases=1;
        while (test-->0){
            int N=in.nextInt ();
            ArrayList<Integer> petrol=new ArrayList<> ();
            ArrayList<Integer> required=new ArrayList<> ();
            for (int i = 0; i < N; i++)   petrol.add (in.nextInt ());
            for (int i = 0; i < N; i++)   required.add (in.nextInt ());
            int sp=  petrol.stream ().mapToInt (x->x).sum ();
            int rp=required.stream ().mapToInt (x->x).sum ();
            if(rp>sp){
                out.append ("Case "+cases++ +": Not possible\n");
            }
            else{
                int start=0,sum=0;
                for (int i = 0; i < N; i++) {
                    sum+=petrol.get (i)-required.get (i);
                    if(sum<0){
                        sum=0;
                        start=i+1;
                    }

                }
                out.append ("Case "+cases++ +": Possible from station "+(++start)+"\n");
            }


        }
        out.flush ();
        out.close ();

    }
}
