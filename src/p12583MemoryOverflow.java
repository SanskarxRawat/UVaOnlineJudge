import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class p12583MemoryOverflow{
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        int cases=1;
        while(test-->0){
            StringTokenizer st=new StringTokenizer (in.readLine ()," ");
            int n=Integer.parseInt (st.nextToken ());
            int k=Integer.parseInt (st.nextToken ());
            char[] peoples=st.nextToken ().toCharArray ();
            int recognize=0;
            HashMap<Character,Integer> map=new HashMap<> ();
            IntStream.rangeClosed ((int)'A',(int) 'Z').forEach (c->map.put ((char) c,0));

            for (int i = 0; i < n; i++) {
                if(map.get (peoples[i])>0) recognize++;
                for (char j = 'A'; j <='Z' ; j++) {
                    map.put (j,map.getOrDefault (j,0)-1);
                }
                map.replace(peoples[i],k);
            }
           out.print ("Case "+cases++ +": "+recognize+"\n");



        }
        out.flush ();
        out.close ();
    }
}