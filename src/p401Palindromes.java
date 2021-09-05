/*
@author : sanskarXrawat
@date   : 4/27/2021
@time   : 10:57 AM
 */
import java.io.*;

public class p401Palindromes {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){
            String s=in.readLine();
            int i,j;
            String a="A   3  HIL JM O   2TUVWXY5";
            String b="01SE Z  8 ";
            boolean flagOne=false,flagTwo=false;
            for ( i = 0,j=s.length()-1 ;i<=j; i++,j--) {
                if(s.charAt(i)!=s.charAt(j)) flagOne=true;
                if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                    if(s.charAt(j)!=a.charAt(s.charAt(i)-'A')) flagTwo=true;
                }
                else{
                    if(s.charAt(j)!=b.charAt(s.charAt(i)-'0')) flagTwo=true;
                }

            }
            out.print(s+" -- is ");
            if(flagOne){
                if(flagTwo) out.append("not a palindrome.");
                else out.append("a mirrored string.");
            }
            else{
                if(flagTwo) out.append("a regular palindrome.");
                else out.append("a mirrored palindrome.");
            }
            out.println("");
        }
        out.flush();
        out.close();


    }
}
