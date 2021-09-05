import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p11799_HorrorDash {
    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=in.nextInt();
        int cases=1;
        while(test-->0){
            int N=in.nextInt();
            ArrayList<Integer> speed=new ArrayList<>(N);
            for (int i = 0; i <N ; i++) speed.add(in.nextInt());
            out.append("Case "+cases++ +": "+ Collections.max(speed)+"\n");
        }
        out.flush();
        out.close();
    }
}
