import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import static java.lang.System.out;

public class p11044SearchingforNessy {
    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test=in.nextInt();
        while(test-->0){
            int r=in.nextInt();
            int c=in.nextInt();
            out.println((r/3)*(c/3));
        }
    }
}
