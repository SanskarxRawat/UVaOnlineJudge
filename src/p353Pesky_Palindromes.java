/*
@author : sanskarXrawat
@date   : 29/4/2021
@time   : 10:55 AM
 */
import java.io.*;
import java.util.HashSet;

public class p353Pesky_Palindromes {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(in.ready()){
            String s=in.readLine();
            HashSet<String> set=new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <=s.length() ; j++) {
                    StringBuilder stringOne=new StringBuilder(s.substring(i,j));
                    StringBuilder stringTwo=new StringBuilder(s.substring(i,j));
                    if(stringOne.toString().equals(stringTwo.reverse().toString())) set.add(stringOne.toString());
                }
            }
            out.append("The string "+"\'"+s+"\' contains "+set.size()+" palindromes.\n");

        }
        out.flush();
        out.close();

    }

}
