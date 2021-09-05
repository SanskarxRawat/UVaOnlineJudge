import java.io.*;
import java.util.stream.IntStream;

public class p11309CountingChaos {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int test=Integer.parseInt(in.readLine());
        while (test-->0){
            String s=in.readLine().replace(":","");
            int hour=Integer.parseInt(s.substring(0,2));
            int mins=Integer.parseInt(s.substring(2));
            do {
                if (mins == 59) {
                    hour = (hour + 1) % 24;
                }
                mins = (mins + 1) % 60;
            }while (!isPalindrome(hour,mins));
            out.println(toString(hour,mins));

        }
        out.flush();
        out.close();
    }
    public static boolean isPalindrome(int hours,int mins){
        String s=Integer.toString(hours*100+mins);
        return IntStream.range(0,s.length()/2).noneMatch(i->s.charAt(i)!=s.charAt(s.length()-1-i));
    }
    public static String toString(int hours,int mins){
        String s=Integer.toString(hours*100+mins);
        for(;s.length()<4;) s="0"+s;

        return s.substring(0,2)+":"+s.substring(2);

    }

}
