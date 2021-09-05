import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;


public class p10742TheNewRuleEuphomia {


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
        private static final int MAX_LENGTH_CHECK = 1000000;
        private static final int MAX_LENGTH_PRIMELIST = 1000000; // tens
        private static final boolean[] check = new boolean[MAX_LENGTH_CHECK]; // store tag
        private static final int[] primeList = new int[MAX_LENGTH_PRIMELIST]; // store prime numbers

        public void solve(int testNumber, FastInput in, FastOutput out) {
            Euler (100000);
            int cases=1;
            while(true){
                int n= in.ri ();
                if(n==0) break;
                int result=0;
                for (int i = 0; i < primeList.length && (n-primeList[i])>primeList[i]; i++) {
                    int upperPrime=n-primeList[i];
                    int  low=i+1,high=primeList.length-1;
                    result+=bs(low,high,upperPrime)-i;
                    out.prt(result);

                }

//                out.printf ("Case %d: %d\n",cases++,ans);


            }
//            debug.debug ("Prime",primeList);


        }
        public static int bs(int low,int high,int key){
            int ans=low-1;

            while (low<=high){
                int mid=(low+high)>>1;
                if(primeList[mid]<=key){
                    low=mid+1;
                    ans=mid;
                }
                else {
                    high=mid-1;
                }
            }
            return ans;
        }



        /**
         * Elatostny sieve method (referred to as Espresso sieve or Ai Si sieve): To obtain all prime numbers within the natural number n, the multiples of all prime numbers not greater than the root number n must be removed, and the rest are prime numbers.
         * For example: give the range n of the value to be sieved and find the prime number within.
         * Solution: first use 2 to screen, that is, leave 2, remove the multiple of 2; then use the next prime number, that is, 3 sieve, leave 3, remove the multiple of 3; then use the next Prime 5 screen, leave 5, remove the multiple of 5; repeat it...
         *
         * Time complexity: O(nloglogn)
         * Inadequacies: 6 is marked when indexI = 2, and once again when indexI = 3. There are duplicate tags and there is room for optimization
         */
        private static void Eratosthenes(int num) {
            int count = 0;
            for (int indexI = 2; indexI <= num; indexI++) {
                // leave indexI when indexI is not the number being culled
                if (!check[indexI]) {
                    primeList[count++] = indexI;
                }
                for (int indexJ = indexI + indexI; indexJ <= num; indexJ += indexI) {
                    check[indexJ] = true;
                }
            }
        }

        /**
         * Euler sieve method: ensure that each composite number is only screened out by its minimum prime factor, and the time complexity is reduced to O(n).
         * Each number is multiplied by the number already in the current prime table. When indexI is a composite number and indexI % primeList[indexJ] == 0, it can only be multiplied by the first prime number 2
         */
        private static void Euler(int num) {
            int count = 0;
            for (int indexI = 2; indexI <= num; indexI++) {
                if (!check[indexI]) {
                    primeList[count++] = indexI;
                }
                // Each number is multiplied by the number already in the current prime table. If indexI is a composite number and indexI % primeList[indexJ] == 0, then it can only be multiplied by the first prime number 2
                // eg 2 × 2, 3 × (2, 3), 4 × (2), 5 × (2, 3, 5), 6 × (2), 7 × (2, 3, 5, 7), 8×(2), 9×(2, 3), 10×(2)
                for (int indexJ = 0; indexJ < count; indexJ++) {
                    // Jump out when too big
                    if (indexI * primeList[indexJ] > num) {
                        break;
                    }
                    check[indexI * primeList[indexJ]] = true;
                    // if indexI is a composite number, and indexI % primeList[indexJ] == 0
                    // ensure that each composite number is only filtered by its smallest prime factor
                    if (indexI % primeList[indexJ] == 0) {
                        break;
                    }
                }
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