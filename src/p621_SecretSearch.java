/*
@author : sanskarXrawat
@date   : 4/27/2021
@time   : 10:58 AM
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p621_SecretSearch {

    public static void main(String[] args) {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test=in.nextInt();

        while(test-->0){
            String s=in.next();
            if(s.equals("1") || s.equals("4") || s.equals("78")){
                System.out.println("+");
                continue;
            }
            else if(s.charAt(0)=='9' && s.charAt(s.length()-1)=='4'){
                System.out.println("*");
                continue;
            }
            else if(s.substring(s.length()-2).equals("35")){
                System.out.println("-");
                continue;
            }
            else{
                System.out.println("?");
            }
        }

    }
}
