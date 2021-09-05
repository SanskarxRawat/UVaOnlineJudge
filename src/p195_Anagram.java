/*
@author : sanskarXrawat
@date   : 5/6/2021
@time   : 10:56 AM
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class p195_Anagram {
    static ArrayList<String> result=new ArrayList<>();

    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=Integer.parseInt(in.readLine());
        while(test-->0) {
            String s=in.readLine();
            permutations("",s);
            Collections.sort(result);
            result.forEach(x->out.println(x));
        }


        out.flush();
        out.close();

    }
    public static void permutations(String prefix,String str){
        int n=str.length();
        if(n==0) result.add(prefix);
        else{
            for (int i = 0; i < n; i++) {
                permutations(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
            }
        }
    }
}
