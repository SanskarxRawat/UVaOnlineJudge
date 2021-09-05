

import java.io.*;
import java.util.Scanner;

public class p10703FreeSpots {
    public static void main(String[] args)throws Throwable {
        Scanner in=new Scanner (new BufferedReader (new InputStreamReader (System.in)));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        while (true){
            int W=in.nextInt ();
            int H= in.nextInt ();
            int N=in.nextInt ();
            if((W+H+N)==0) break;
            boolean[][] spaces=new  boolean[W][H];
            int  maxSpace=W*H;

            for (int i = 0; i < N; i++) {
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();

                for (int x = Math.min(x1, x2) - 1; x < Math.max(x1, x2); x++) {
                    for (int y = Math.min(y1, y2) - 1; y < Math.max(y1, y2); y++) {
                        if (!spaces[x][y]) {
                            spaces[x][y] = true;
                            maxSpace--;
                        }
                    }
                }
            }
            if(maxSpace==0)
                out.append ("There is no empty spots.\n");
            else if(maxSpace==1)
                out.append ("There is one empty spot.\n");
            else
                out.append ("There are "+maxSpace+" empty spots.\n");
            

        }
        out.flush ();
        out.close ();


    }


}
