import java.io.*;

public class p11586_TrainTracks {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=Integer.parseInt(in.readLine());
        while(test-->0){
            String s=in.readLine();
            int m=0,f=0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='M') m++;
                else if(s.charAt(i)=='F') f++;
            }
            out.append((m==f && m>1)?"LOOP\n":"NO LOOP\n");
        }
        out.flush();
        out.close();

    }
}
