import java.io.*;
import java.util.*;

public class p978LemmingsBattle {
    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int test=Integer.parseInt (in.readLine ());
        while (test-->0){
            String[] line=in.readLine ().split (" ");
            int B=Integer.parseInt (line[0]);
            int SG=Integer.parseInt (line[1]);
            int SB=Integer.parseInt (line[2]);
            PriorityQueue<Integer> greenArmy=new PriorityQueue<> (SG, new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1>o2){
                        return -1;
                    }
                    return 1;
                }
            });
            PriorityQueue<Integer> blueArmy=new PriorityQueue<> (SB, new Comparator<Integer> () {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1>o2){
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i <SG ; i++) greenArmy.add(Integer.parseInt (in.readLine ()));
            for (int i = 0; i <SB ; i++) blueArmy.add(Integer.parseInt (in.readLine ()));

            while(true){
                if(greenArmy.isEmpty ()&&blueArmy.isEmpty ()){
                    out.append ("green and blue died\n");
                    break;
                }
                else if(greenArmy.isEmpty ()){
                    out.append ("blue wins\n");
                    while(!blueArmy.isEmpty ()) out.println(blueArmy.poll ());
                    break;
                }
                else if(blueArmy.isEmpty ()){
                    out.append ("green wins\n");
                    while(!greenArmy.isEmpty ()) out.println(greenArmy.poll ());
                    break;
                }
                else{
                    int counter=0;
                    List<Integer> gL=new ArrayList<> ();
                    List<Integer> bL=new ArrayList<> ();
                    while(!blueArmy.isEmpty ()&&!greenArmy.isEmpty () &&counter<B){
                        int g=greenArmy.poll ();
                        int b=blueArmy.poll ();
                        if (g>b) {
                            gL.add(g-b);
                        } else if (b > g) {
                            bL.add(b - g);
                        }
                        counter++;
                    }
                    greenArmy.addAll(gL);
                    blueArmy.addAll (bL);
                }

            }
            if(test>0) out.println ();



        }
        out.flush ();
        out.close ();
    }

}

