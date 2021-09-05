import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p11332_SummingDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        boolean flag = true;
        while (flag) {
            int n = in.nextInt();
            if (n == 0) break;
            System.out.println(calculate(n));

        }
    }

        public static int calculate(int n){
            long sum=0;
            String s=String.valueOf(n);
            for (int i = 0; i <s.length() ; i++) {
                sum+=Integer.parseInt(s.charAt(i)+"");
            }
            if(sum<10)
                return (int) sum;
            return calculate((int)sum);
        }
    }
