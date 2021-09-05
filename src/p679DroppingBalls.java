import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;


public class p679DroppingBalls {
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread (null, new TaskAdapter (), "", 1 << 29);
        thread.start ();
        thread.join ();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput (inputStream);
            FastOutput out = new FastOutput (outputStream);
            Solution solver = new Solution ();
            solver.solve (1, in, out);
            out.close ();
        }
    }

    static class Solution {
        Debug debug = new Debug (true);
        static int limit;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int test= in.ri ();


            while(test-->0){
                int  d= in.ri ();
                if(d==-1) break;
                int balls= in.ri ();
                limit=1<<(d-1);
                out.prt (binarySearch(1,balls)+"\n");
            }
        }
        public static  int  binarySearch(int n,int ball){
            if(n>=limit) return n;

            int left=(n<<1),right=left+1;
            if(ball%2==0) return binarySearch (right,ball/2);
            return binarySearch (left,ball/2+1);
        }

    }


    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 32 << 10;
        private final Writer os;
        private StringBuilder cache = new StringBuilder (THRESHOLD * 2);

        public FastOutput append(CharSequence csq) {
            cache.append (csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append (csq, start, end);
            return this;
        }

        private void afterWrite() {
            if (cache.length () < THRESHOLD) {
                return;
            }
            flush ();
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this (new OutputStreamWriter (os));
        }

        public FastOutput append(char c) {
            cache.append (c);
            afterWrite ();
            return this;
        }

        public FastOutput append(String c) {
            cache.append (c);
            afterWrite ();
            return this;
        }

        public FastOutput println(String c) {
            return append (c).println ();
        }

        public FastOutput println() {
            return append ('\n');
        }

        final <T> void prt(T a) {
            append (String.valueOf (a));
        }

        public FastOutput flush() {
            try {
//            boolean success = false;
//            if (stringBuilderValueField != null) {
//                try {
//                    char[] value = (char[]) stringBuilderValueField.get(cache);
//                    os.write(value, 0, cache.length());
//                    success = true;
//                } catch (Exception e) {
//                }
//            }
//            if (!success) {
                os.append (cache);
//            }
                os.flush ();
                cache.setLength (0);
            } catch (IOException e) {
                throw new UncheckedIOException (e);
            }
            return this;
        }

        public void close() {
            flush ();
            try {
                os.close ();
            } catch (IOException e) {
                throw new UncheckedIOException (e);
            }
        }

        public String toString() {
            return cache.toString ();
        }

    }


    static class FastInput {
        private final InputStream is;
        private StringBuilder defaultStringBuf = new StringBuilder (1 << 13);
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        public void populate(int[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readInt ();
            }
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read (buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read ();
            }
        }

        public String next() {
            return readString ();
        }

        public int ri() {
            return readInt ();
        }

        public int readInt() {
            boolean rev = false;

            skipBlank ();
            if (next == '+' || next == '-') {
                rev = next == '-';
                next = read ();
            }

            int val = 0;
            while (next >= '0' && next <= '9') {
                val = val * 10 - next + '0';
                next = read ();
            }

            return rev ? val : -val;
        }

        public String readString(StringBuilder builder) {
            skipBlank ();

            while (next > 32) {
                builder.append ((char) next);
                next = read ();
            }

            return builder.toString ();
        }

        public String readString() {
            defaultStringBuf.setLength (0);
            return readString (defaultStringBuf);
        }

    }


    static class Debug {
        private boolean offline;
        private PrintStream out = System.err;
        static int[] empty = new int[0];

        public Debug(boolean enable) {
            offline = enable && System.getSecurityManager () == null;
        }

        public Debug debug(String name, Object x) {
            return debug (name, x, empty);
        }

        public Debug debug(String name, Object x, int... indexes) {
            if (offline) {
                if (x == null || !x.getClass ().isArray ()) {
                    out.append (name);
                    for (int i : indexes) {
                        out.printf ("[%d]", i);
                    }
                    out.append ("=").append ("" + x);
                    out.println ();
                } else {
                    indexes = Arrays.copyOf (indexes, indexes.length + 1);
                    if (x instanceof byte[]) {
                        byte[] arr = (byte[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof short[]) {
                        short[] arr = (short[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof boolean[]) {
                        boolean[] arr = (boolean[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof char[]) {
                        char[] arr = (char[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof int[]) {
                        int[] arr = (int[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof float[]) {
                        float[] arr = (float[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof double[]) {
                        double[] arr = (double[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else if (x instanceof long[]) {
                        long[] arr = (long[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    } else {
                        Object[] arr = (Object[]) x;
                        for (int i = 0; i < arr.length; i++) {
                            indexes[indexes.length - 1] = i;
                            debug (name, arr[i], indexes);
                        }
                    }
                }
            }
            return this;
        }

    }
}


