/*
@author : sanskarXrawat
@date   : 5/15/2021
@time   : 11:07 PM
 */
import java.io.*;
import java.util.*;

public class p1237ExpertEnough {
    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out = new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test = Integer.parseInt (in.readLine ());

        boolean first = true;
        while (test-- > 0) {
            if(first)
                first = false;
            else
                out.append("\n");
            ArrayList<String> manufactures=new ArrayList<> ();
            int dataSize = Integer.parseInt (in.readLine ());
            int[][] prices=new int[dataSize][2];
            for (int i = 0; i < dataSize; i++) {
                StringTokenizer st=new StringTokenizer (in.readLine ()," ");
                manufactures.add (st.nextToken ());
                prices[i][0]=Integer.parseInt (st.nextToken ());
                prices[i][1]=Integer.parseInt (st.nextToken ());
            }

            int Q = Integer.parseInt (in.readLine ());
            while (Q-- > 0) {
                int p = Integer.parseInt (in.readLine ());
                int counter = -1;
                String s = "";
                for (int i = 0; i < dataSize; i++) {
                    if (p >= prices[i][0] && p<=prices[i][1]) {
                     if(counter<0) counter=i;
                     else{
                         counter=-1;
                         break;
                     }

                    }

                }
                out.append (counter<0?"UNDETERMINED\n":manufactures.get (counter)+"\n");
            }
        }
            out.flush ();
            out.close ();
        }

    }


