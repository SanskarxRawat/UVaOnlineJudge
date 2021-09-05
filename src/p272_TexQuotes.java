/*
@author : sanskarXrawat
@date   : 4/30/2021
@time   : 10:55 AM
 */
import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

public class p272_TexQuotes {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s;
        boolean flag=true;
        while(in.hasNext()) {
            s = in.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='\u001a') // end of file character
                        break;
                if(s.charAt(i)=='\"'){
                    if(flag){
                        out.print("``");
                        flag=false;
                        continue;
                    }
                    else{
                        out.print("''");
                        flag=true;
                        continue;
                    }
                }
                out.print(s.charAt(i));
            }
            out.println();
        }

    }

}

