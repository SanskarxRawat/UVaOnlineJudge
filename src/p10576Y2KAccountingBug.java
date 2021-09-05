import java.io.*;

public class p10576Y2KAccountingBug {
    static int s,d,value[]=new int[12];
    static int  max;
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        while(in.ready()){
            String[] a=in.readLine ().split(" ");
             s=Integer.parseInt (a[0]);
             d=Integer.parseInt (a[1]);
            max=-1;
            backtrack (0,0);
            if(max==-1) out.append ("Deficit"+"\n");
            else out.append (max+"\n");
        }
        out.flush ();
        out.close ();
    }
    public static void backtrack(int m,int sum){

        if(m==12){
            int c=0;
            for (int i = 0; i+5 <=12; i++) {
                    int k=0;
                for (int j = i; j < i+5; j++) {
                    k+=value[j];

                }
                if(k<0) c++;
            }
            if(c==8) max=StrictMath.max (max,sum);
        }
        else{
            value[m]=s;
            backtrack (m+1,sum+s);
            value[m]=-d;
            backtrack (m+1,sum-d);
        }
    }

}
