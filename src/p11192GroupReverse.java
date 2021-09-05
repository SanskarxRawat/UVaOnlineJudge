import java.io.*;


public class p11192GroupReverse {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));


        while (true){
            String[] line=in.readLine ().trim ().split (" ");
            if(line[0].equals ("0")) break;
            String s=line[1];
            int groups=s.length ()/Integer.parseInt (line[0]);
            for (int i = 0; i < s.length (); i+= groups) {
                for (int j = i+groups-1;j>=i; j--) {
                    out.append (s.charAt (j));
                }
            }
            out.append ("\n");
        }
        out.flush ();
        out.close ();
    }
}
