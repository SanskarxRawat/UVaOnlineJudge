import java.io.*;
import java.util.*;


public class p11242TourdeFrance {
    public static void main(String[] args)throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while (true){
            int f=in.nextInt();
            if(f==0) break;
            int r=in.nextInt ();
            Double[] F=new Double[f];
            Double[] R=new Double[r];
            for (int i = 0; i < f; i++) F[i]=in.nextDouble ();
            for (int j = 0; j < r; j++) R[j]=in.nextDouble ();


            Arrays.sort (F); Arrays.sort (R);
            ArrayList<Double> list=new ArrayList<> ();
            for (int i = 0; i < f; i++){
                for (int j = 0; j <r ; j++){
                    list.add ((R[j]/F[i]));
                }
            }
            Collections.sort (list);
            double maxSpread=Double.MIN_VALUE;
            for (int i = 1; i < list.size (); i++) maxSpread=StrictMath.max (maxSpread,list.get (i)/list.get (i-1));
            out.printf("%.2f\n",maxSpread);
        }
        out.flush ();
        out.close ();
    }
}
