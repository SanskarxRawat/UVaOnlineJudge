import java.io.*;


public class p10018_ReverseAdd {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=Integer.parseInt(in.readLine());
        while(test-->0){
            int counter=0;
            long num=Long.parseLong(in.readLine());
            long reversed=reverseNum(num);
            while(num!=reversed){
                num+=reversed;
                reversed=reverseNum(num);
                counter++;
            }
            out.println(counter+" "+num);

        }
        out.flush();
        out.close();
    }

    public static long reverseNum(long num){
        long reversed=0;
        while(num>0){
            reversed=reversed*10+num%10;
            num/=10;
        }
        return reversed;
    }

}
