import java.io.*;

public class p12403SaveShetu{
    public static void main(String[] args)throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        int test=Integer.parseInt (in.readLine ());
        int money=0;

        while (test-->0){
            String[] line=in.readLine ().split (" ");
            String s=line[0];
            if(s.equals ("donate")){
                int donations=Integer.parseInt (line[1]);
                money+=donations;
            }
            else
                out.println (money);


        }
        out.flush ();
        out.close ();
    }
}