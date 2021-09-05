import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11222OnlyIDidIt {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int cases=1;
        int test=Integer.parseInt (in.readLine ());
        while(test-->0){
            in.readLine ();
            HashSet<Integer> first=new HashSet<> ();
            HashSet<Integer> second=new HashSet<> ();
            HashSet<Integer> third=new HashSet<> ();
            StringTokenizer st=new StringTokenizer (in.readLine ()," ");
            int n1=Integer.parseInt (st.nextToken ());
            for (int i = 0; i<n1; i++) {
                first.add (Integer.parseInt (st.nextToken ()));
            }
            st=new StringTokenizer (in.readLine ()," ");

            int n2=Integer.parseInt (st.nextToken ());
            for (int i = 0; i<n2; i++) {
                second.add (Integer.parseInt (st.nextToken ()));
            }
            st=new StringTokenizer (in.readLine ()," ");

            int  n3=Integer.parseInt (st.nextToken ());
            for (int i = 0; i<n3; i++) {
                third.add (Integer.parseInt (st.nextToken ()));
            }
            PriorityQueue<Integer>[] solved=new PriorityQueue[3];
            solved[0]=new PriorityQueue<Integer> (); solved[1]=new PriorityQueue<Integer> (); solved[2]=new PriorityQueue<Integer> ();

            int max=0;

            for(Integer f:first){
                if(!second.contains (f) && !third.contains (f)){
                    solved[0].add (f);
                }
            }
            max=StrictMath.max (max,solved[0].size ());
            for(Integer s:second){
                if(!first.contains (s) && !third.contains (s)){
                    solved[1].add (s);
                }
            }
            max=StrictMath.max(max,solved[1].size ());

            for(Integer t:third){
                if(!second.contains (t) && !first.contains (t)){
                    solved[2].add (t);
                }
            }
            max=StrictMath.max (max,solved[2].size ());
            out.append ("Case #"+cases++ +":\n");
            for (int i = 0; i < solved.length; i++) {
                if(solved[i].size ()==max){
                    out.append ((i+1)+" "+solved[i].size ());
                    while(!solved[i].isEmpty ()){
                        out.append (" "+solved[i].poll ());
                    }
                    out.append ("\n");
                }

            }
        }
        out.flush ();
        out.close ();
    }
}
