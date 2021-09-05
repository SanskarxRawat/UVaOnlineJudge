import java.io.*;

public class p12356ArmyBuddies {
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));

        while(true){
            String[] line=in.readLine ().trim ().split (" ");
            int S=Integer.parseInt (line[0]);
            int B=Integer.parseInt (line[1]);
            if(S+B==0) break;
            Soldier[] soldiers=new Soldier[S+2];
            soldiers[0]=new Soldier (0,1);
            soldiers[S+1]=new Soldier(S,S+1);
            for (int i = 0; i <=S; i++) {
                soldiers[i]=new Soldier (i-1,i+1);

            }
            for (int i = 0; i < B; i++) {
                line=in.readLine ().trim ().split (" ");
                int l=Integer.parseInt (line[0]);
                int r=Integer.parseInt (line[1]);
                String left=soldiers[l].left<1?"*":soldiers[l].left+"";
                String right=soldiers[r].right>S?"*":soldiers[r].right+"";
                out.append (left+" "+right+"\n");
                soldiers[soldiers[l].left].right=soldiers[r].right;
                soldiers[soldiers[r].right].left=soldiers[l].left;
            }
            out.append ("-\n");
        }
        out.flush ();
        out.close ();


    }
    static class Soldier{
        int left,right;

        public Soldier(int left,int right){
            this.left=left;
            this.right=right;
        }
    }
}
