import java.io.*;
import java.util.StringTokenizer;

public class p11942_LumberjackSequencing {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int test=Integer.parseInt(in.readLine());
        out.append("Lumberjacks:"+"\n");
        while(test-->0){
            StringTokenizer tokenizer=new StringTokenizer(in.readLine());
            boolean ascending=true,descending=true;
            int last=Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < 9; i++) {
                int counter=Integer.parseInt(tokenizer.nextToken());
                if(counter>last) descending=false;
                if(last>counter) ascending=false;
                last=counter;
            }
            out.append((ascending||descending)?"Ordered\n":"Unordered\n");
        }
        out.flush();
        out.close();
    }

}
