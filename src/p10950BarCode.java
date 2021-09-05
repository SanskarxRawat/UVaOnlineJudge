
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
@author : sanskarXrawat
@date   : 5/23/2021
@time   : 3:21 PM
 */


public class p10950BarCode {
    static BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
    static PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
    static ArrayList<Pair<Character,String>> barCode;
    static int counter;

    public static void main(String[] args)throws Throwable{

        int cases=1;
        while(true){
            int n=Integer.parseInt (in.readLine ());
            if(n==0) break;
            barCode=new ArrayList<> ();
            for (int i = 0; i < n; i++) {
                String[] line=in.readLine ().split (" ");
                barCode.add (new Pair<Character,String> (line[0].charAt (0),line[1]));
            }
            Collections.sort (barCode, Comparator.comparing (Pair::getKey));
            String s=in.readLine ();
            StringBuilder current=new StringBuilder ();
            counter=0;
            out.append ("Case #"+cases++ +"\n");
            backtrack (0,current,barCode,s);
            out.println ();
        }
        out.flush ();
        out.close ();
    }

    public static void backtrack(int index,StringBuilder current,ArrayList<Pair<Character,String>> encode,String s){

        if(index==s.length ()){
            counter++;
            out.append (current.toString ()+"\n");
            return;
        }
        while(index<s.length ()  &&  s.charAt (index)=='0') index++;
        if(index>=s.length ()) return;

        for(Pair<Character,String> x:encode){
           if(x.getValue ().length ()>s.length ()-index) continue;
           boolean valid=true;
            for (int i = 0; i < x.getValue ().length () && valid ;i++) {
                if(s.charAt (i+index)!=x.getValue ().charAt (i)) valid=false;
            }
            if(valid){
                current.append (x.getKey ());
                backtrack (index+x.getValue ().length (),current,encode,s);
                current.deleteCharAt (current.length ()-1);
            }
            if(counter>=100) return;
        }
    }

    private static class Pair<Character, String> {
        private  final Character c;
        private final String s;
        public Pair(Character c, String s) {
            this.c=c;
            this.s=s;
        }
        private Character getKey(){
            return c;
        }
        private String getValue(){
            return s;
        }

    }
}
