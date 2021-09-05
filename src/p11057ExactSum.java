import java.io.*;
import java.util.*;

public class p11057ExactSum{
    public static void main(String[] args)throws Throwable{
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        HashMap<Integer,Integer> map;

        while (in.hasNext ()){
            int n= in.nextInt ();
            if(n==0) break;
            map=new HashMap<> ();
            for (int i = 0; i < n; i++) {
                map.merge (in.nextInt (),1,Integer::sum);
            }
            int m=in.nextInt ();
            int i=0,j=0,diff=Integer.MAX_VALUE;

            for(Map.Entry<Integer,Integer> e:map.entrySet ()){
                int  key=e.getKey ();
                int  required=m-key;
                if(required==key){
                    if(e.getValue ()>1){
                        diff=0;
                        i=key;
                        j=key;
                    }
                }
                else{
                    if(map.containsKey (required)){
                        int currentDifference=Math.abs(required-key);
                        if(currentDifference<diff){
                            diff=currentDifference;
                            i=Math.min(key,required);
                            j=Math.max (key,required);
                        }

                    }

                }
            }

            out.printf ("Peter should buy books whose prices are %d and %d.\n\n",i,j);
            in.nextLine ();
        }
        out.flush ();
        out.close ();

    }
}