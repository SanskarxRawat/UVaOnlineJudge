import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import static java.lang.System.out;

public class p10550_CombinationLock {
    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] pattern;
        while (in.hasNext()){
            int degree=1080,sum=0;
            pattern=new int[4];
            for (int i = 0; i < 4; i++) {
                pattern[i]=in.nextInt();
                sum+=pattern[i];
            }
            if(sum==0) break;
            degree+=rotate(pattern[1],pattern[0]);
            degree+=rotate(pattern[1],pattern[2]);
            degree+=rotate(pattern[3],pattern[2]);
            out.println(degree);

        }

    }
    static int rotate(int a, int b){
        int sum=0;
        for (int i = a;i!=b; i =(i+1)%40,sum++);
            return sum*9;

    }
}
