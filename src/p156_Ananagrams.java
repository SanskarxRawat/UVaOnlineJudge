/*
@author : sanskarXrawat
@date   : 5/6/2021
@time   : 10:56 AM
 */
import java.io.*;
import java.util.*;

public class p156_Ananagrams {
    public static void main(String[] args) throws Throwable {
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter  out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        HashMap<ArrayList<Integer>,ArrayList<String>> map=new HashMap<>();
        PriorityQueue<String> priorityQueue=new PriorityQueue<>();


        while (in.hasNext()){
            String word=in.next();
            if(word.equals("#")) break;

            ArrayList<Integer> alpha=new ArrayList<>(Collections.nCopies(26,0));

            for (int i = 0; i < word.length(); i++) {
                int value=Character.toLowerCase(word.charAt(i))-97;
                alpha.set(value,alpha.get(value)+1);
            }
            if (!map.containsKey(alpha))
            map.put(alpha, new ArrayList<String>());
            map.get(alpha).add(word);


        }
        for(ArrayList<String> x:map.values()) if(x.size()==1) priorityQueue.add(x.get(0));
        while (!priorityQueue.isEmpty()) out.print(priorityQueue.poll()+"\n");

        out.flush();
        out.close();
    }
}
