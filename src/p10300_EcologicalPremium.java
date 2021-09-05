import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p10300_EcologicalPremium {
    public static void main(String[] args) {
        int[] array;
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test= in.nextInt();
        while(test-->0){
            int farmer= in.nextInt();
            int sum=0;
            while(farmer-->0){
                array=new int[3];
                for (int i = 0; i < 3; i++) {
                    array[i]= in.nextInt();
                }
                sum+=array[0]*array[2];
            }
            System.out.println(sum);
        }
    }
}
