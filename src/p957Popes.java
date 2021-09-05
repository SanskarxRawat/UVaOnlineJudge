import java.io.*;

public class p957Popes{
    public static void main(String[] args)throws  Throwable{
        BufferedReader in=new BufferedReader(new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));


        while(in.ready ()){
            int y=Integer.parseInt (in.readLine ());
            int p=Integer.parseInt (in.readLine ());
            int[] arr=new int[p];

            for (int i = 0; i < p; i++) {
                arr[i]=Integer.parseInt (in.readLine ());
            }
            int max=-1,head=0,s=0,t=0;

            for (int i = 0; i < p; i++) {
                while (arr[i]-arr[head]>=y){
                    head++;
                }
                if(max<i-head+1){
                    max=i-head+1;
                    s=head;
                    t=i;
                }

            }
            out.printf ("%d %d %d\n",max,arr[s],arr[t]);
        }
        out.flush ();
        out.close ();
    }
}