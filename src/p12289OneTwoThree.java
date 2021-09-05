import java.io.*;

public class p12289OneTwoThree{
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        while (test-->0){
            char[] s= in.readLine ().toCharArray ();
            if(s.length>3)
                out.append ("3\n");
            else {
                if( (s[0]=='o' && (s[1]=='n' || s[2]=='e')) || s[1]=='n' && (s[2]=='e')){
                    out.append ("1\n");
                }
                else
                    out.append ("2\n");
            }

        }
        out.flush ();
        out.close ();


    }
}