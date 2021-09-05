/*
@author : sanskarXrawat
@date   : 4/29/2021
@time   : 10:54 AM
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import static java.lang.System.out;

public class p343_WhatsBase {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while(in.hasNext()){
             String a=in.next();
             String b=in.next();

             boolean found=false;
             BigInteger big_A,big_B;

             for (int i = 2; i <=36 ; i++) {
                 try {
                     big_A = new BigInteger(a, i);
                 } catch (Exception e) {
                     continue;
                 }

                 for (int j = 2; j <= 36; j++) {
                     try {
                         big_B = new BigInteger(b, j);
                     } catch (Exception e) {
                         continue;
                     }
                     if (big_A.compareTo(big_B) == 0) {
                         found = true;
                         out.println(a + " (base " + i + ") = " + b + " (base " + j + ")");
                         break;
                     }
                 }
                 if (found) {
                     break;
                 }
             }

                 if(!found){
                     out.println(a + " is not equal to " + b + " in any base 2..36");
                 }

         }
         out.close();
    }


}
