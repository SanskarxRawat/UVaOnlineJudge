import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;


public class p10706NumberSequence {


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

        public void solve(int testNumber, FastInput in, FastOutput out) {

            long[] l = new long[4_000_1];
            long count = 0L, last;
            StringBuilder sb = new StringBuilder ();
            for (int i = 1; i < 4_00_00; i++) {
                last = (i + "").length ();
                count += last;
                l[i] = count + l[i - 1];
                sb.append (i);
            }
            int test = in.ri ();
            for (int j = 0; j < test; j++) {
                int pos = in.ri();
                int lo = 1, hi = 40000;
                for (int i = 0; i < 20; i++) {
                    int mid = (lo + hi) / 2;
                    if (l[mid] == pos) {
                        lo = mid;
                        break;
                    } else if (l[mid] < pos) {
                        lo = mid;
                    } else
                        hi = mid;
                }
                if(pos>l[lo])
                    out.prtl (sb.charAt ((int) (pos-l[lo]-1)));

                else
                    out.prtl (lo);
            }
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
            append (a + " ");
        }

        final <T> void prtl(T a){append (a+"\n");}

        public FastOutput flush() {
            try {
                // boolean success = false;
                // if (stringBuilderValueField != null) {
                //  try {
                //  char[] value = (char[]) stringBuilderValueField.get(cache);
                //          os.write(value, 0, cache.length());
                //                  success = true;
                //          } catch (Exception e) {
                //      }
                //  }
                //  if (!success) {
                //  }
                os.append (cache);
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

        public FastOutput printf(String format, Object... args) {
            return append (String.format (format, args));
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

        public void populate(long[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readLong ();
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

        public int readLong() {
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

        public long rl() {
            return readLong ();
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

        public int rs(char[] data, int offset) {
            return readString (data, offset);
        }

        public int rs(char[] data) {
            return rs (data, 0);
        }

        public int readString(char[] data, int offset) {
            skipBlank ();

            int originalOffset = offset;
            while (next > 32) {
                data[offset++] = (char) next;
                next = read ();
            }

            return offset - originalOffset;
        }

        public char rc() {
            return readChar ();
        }

        public char readChar() {
            skipBlank ();
            char c = (char) next;
            next = read ();
            return c;
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