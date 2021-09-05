import java.io.*;

public class p10050Hartals {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        while (test-->0){
            int days=Integer.parseInt (in.readLine ());
            int party=Integer.parseInt (in.readLine ());
            int[] p=new int[party];
            for (int i = 0; i < party; i++) {
                p[i]=Integer.parseInt (in.readLine ());
            }
            int  counter=0;
            for (int i = 1; i <=days ; i++) {
                if((i+1)%7==0 || i%7==0) continue;
                for (int j = 0; j <party; j++) {
                    if(i%p[j]==0){
                        counter++;
                        break;
                    }

                }

            }

            out.println (counter);
        }


        out.flush ();
        out.close ();
    }
}
