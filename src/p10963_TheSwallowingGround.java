import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p10963_TheSwallowingGround {
    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test=in.nextInt();
        while(test-->0){
            int n= in.nextInt()-1;
            double difference=Math.abs(in.nextDouble()-in.nextDouble());
            boolean flag=true;
            while (n-->0){
                double currentDifference=Math.abs(in.nextDouble()-in.nextDouble());
                if(currentDifference!=difference)
                    flag=false;
            }
            System.out.println(flag?"yes":"no");
            if(test!=0) System.out.println();

        }
        in.close();
    }
}
