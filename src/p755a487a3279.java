import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class p755a487a3279 {
    static HashMap<Character , Integer> hashMap = new HashMap<>();

    public static void main(String[] args)throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        fill ();

        int test=Integer.parseInt (in.readLine ());
        while (test-->0){
            TreeMap<String,Integer> map=new TreeMap<> ();
            int N=Integer.parseInt (in.readLine ());
            while (N-->0){
                String o=converter (in.readLine ());
                if(map.containsKey (o)) map.put (o,map.get (o)+1);
                else map.put (o,1);
            }
            boolean flag=false;
            for(Map.Entry<String,Integer> O:map.entrySet ()){
                if(O.getValue ()>1) {
                    out.append (O.getKey ()).append (" ").append (String.valueOf (O.getValue ())).append ("\n");
                    flag=true;
                }
            }
            if(!flag) out.append ("No duplicates.\n");
            if(test!=0)out.append ("\n");
        }
        out.flush ();
        out.close ();

    }

    static void fill (){
        int cnt = 0 ;
        for (int i = 0 ; i < 26 ; i += 3){
            for (int j = 0 ; j < 3 ; ++j){
                char c = (char)(i + j + 'A');
                if (c == 'Q') { i ++ ; j -- ;}
                else if (c == 'Z') continue;
                else hashMap.put(c , cnt + 2);

            }
            ++cnt;
        }
        for (int i = 0 ; i < 10 ; ++i)
            hashMap.put((char)(i + '0') , i);
    }

    static String converter(String s){
        StringBuilder sb=new StringBuilder ();
        for (int i = 0; i < s.length (); i++) {
            if(s.charAt (i)=='-') continue;
            else if(sb.length ()==3) sb.append ('-').append (hashMap.get(s.charAt (i)));
            else sb.append (hashMap.get (s.charAt (i)));
        }
        return sb.toString ();

    }
}

