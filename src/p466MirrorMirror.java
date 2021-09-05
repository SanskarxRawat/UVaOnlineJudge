import java.io.*;

public class p466MirrorMirror {
    static char[][] pattern;
    static char[][] transformed;
    static int N;
    public static void main(String[] args) throws Throwable {
        BufferedReader in=new BufferedReader (new InputStreamReader (System.in));
        PrintWriter out=new PrintWriter (new BufferedWriter (new OutputStreamWriter (System.out)));
        int cases=1;
        while (in.ready ()){
             N=Integer.parseInt (in.readLine ());
             pattern=new char[N][N];
             transformed=new char[N][N];
            for (int i = 0; i < N; i++) {
                String[] line=in.readLine ().split (" ");
                for (int j = 0; j < N; j++) {
                    pattern[i][j]=line[0].charAt (j);
                    transformed[i][j]=line[1].charAt (j);
                }
            }
            if(preserved ()){
                out.append ("Pattern "+cases++ +" was preserved.\n");
            }
            else if(rotate90 ()){
                out.append ("Pattern "+cases++ +" was rotated 90 degrees.\n");

            }
            else if(rotate180 ()){
                out.append ("Pattern "+cases++ +" was rotated 180 degrees.\n");

            }
            else if(rotate270 ()){
                out.append ("Pattern "+cases++ +" was rotated 270 degrees.\n");

            }
            else if(verticalR ()){
                out.append ("Pattern "+cases++ +" was reflected vertically.\n");
            }
            else {
                int counter=vertR_rot ();
                if(counter!=-1){
                    out.append ("Pattern " + cases++ + " was reflected vertically and rotated " + counter + " degrees.\n");
                }
                else
                    out.append ("Pattern "+cases++ +" was improperly transformed.\n");
            }




        }
        out.flush ();
        out.close ();
    }
    static boolean preserved(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pattern[i][j]!=transformed[i][j]) return false;
            }
        }
        return true;
    }
    static boolean rotate90(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pattern[i][j]!=transformed[j][N-1-i]) return false;
            }
        }
        return true;
    }
    static boolean rotate180(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pattern[i][j]!=transformed[N-1-i][N-1-j]) return false;
            }
        }
        return true;
    }
    static boolean rotate270(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pattern[i][j]!=transformed[N-1-j][i]) return false;
            }
        }
        return true;
    }
    static boolean verticalR(){
        for (int i = 0; i < N>>1; i++) {
            for (int j = 0; j < N; j++) {
                if(pattern[i][j]!=transformed[N-1-i][j]) return false;
            }
        }
        return true;
    }
    static int vertR_rot (){
        char tmp [][] = new char[N][N];
        for (int i = 0 ; i < N ; ++i) for (int j = 0 ; j < N ; ++j) tmp[i][j] = pattern[i][j];
        for (int i = 0 ; i < N ; ++i){
            for (int j = 0 ; j < N ; ++j){
                pattern[i][j] = tmp[N - 1 - i][j];
            }
        }

        if (rotate90 ()) return 90;
        else if (rotate180 ()) return 180;
        else if (rotate270 ()) return 270;
        else return - 1;
    }


}
