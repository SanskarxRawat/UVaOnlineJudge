/*
@author : sanskarXrawat
@date   : 5/15/2021
@time   : 11:11 PM
 */
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p10976FractionsAgain {
    public static void main(String[] args) throws Throwable{
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter (new OutputStreamWriter (System.out)));
        StringBuilder builder=new StringBuilder ();
        while(in.ready ()){
            int k=Integer.parseInt (in.readLine ());
            Queue<Point> queue=new LinkedList<Point> ();
            for (int x = k+1; x<=k<<1; x++) {
                if((1l*k*x)%(x-k)==0){
                    int y=(x*k)/(x-k);
                    queue.add (new Point (y,x));
                }

            }
            builder.append (queue.size ()+"\n");
            while (!queue.isEmpty ()){
                int x=queue.peek ().x,y= queue.poll ().y;
                builder.append ("1/"+k+" = 1/"+x+" + "+"1/"+y+"\n");

            }

        }
        out.print(builder.toString ());
        out.flush ();
        out.close ();

    }
}
