import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p454Anagrams {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        while(test-->0){
            ArrayList<String> words=new ArrayList<> ();

            while(in.ready ()){
                String s=in.readLine ();
                words.add (s);
            }
            Collections.sort(words);
            for (int i = 0; i <words.size (); i++) {
                for (int j = i+1; j <words.size () ; j++) {
                    if(converter (words.get (i)).equals (converter (words.get(j)))){
                        out.println (words.get(i)+" = "+words.get (j));
                    }

                }
            }

        }
        out.flush ();
        out.close ();

    }
    public static String converter(String s){
        char[] myString=s.replaceAll (" ","").toCharArray ();
        Arrays.sort (myString);
        return String.valueOf (myString);
    }
}
