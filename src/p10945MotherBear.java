import java.io.*;
import java.util.stream.IntStream;

public class p10945MotherBear {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){
            String s=in.readLine();
            if(s.equals("DONE")) break;
           out.println(isPalindrome(s)?"You won't be eaten!":"Uh oh..");
        }
        out.flush();
        out.close();

    }
    public static boolean isPalindrome(String s){
        String temp=s.replaceAll("\\p{Punct}","").replaceAll("\\s","").toLowerCase();
        return IntStream.range(0,temp.length()/2).noneMatch(i->temp.charAt(i)!=temp.charAt(temp.length()-i-1));
    }
}
