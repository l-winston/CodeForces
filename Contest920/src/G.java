import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class G {
    static byte[][] isCoprime = new byte[10000][10000];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int Q = Reader.nextInt();

        for (int q = 0; q < Q; q++) {
            int x = Reader.nextInt(), p = Reader.nextInt(), k = Reader.nextInt();

            int count = 0;
            int current = x;
            while (count < k) {
                current++;
                if (isCoprime(current, p))
                    count++;
            }
            System.out.println(current);
        }
    }

    static boolean isCoprime(int a, int b){

        if(a < isCoprime.length && b < isCoprime[0].length && isCoprime[a][b] != 0) {
            System.out.println("dp used");
            return isCoprime[a][b] == 2;
        }

        if (a == 0)
            return b==1;
        if (b == 0)
            return a==1;
        boolean bool = isCoprime(b, a%b);
        isCoprime[a][b] = (byte) (bool ? 2 : 1);
        return bool;
    }

    /**
     * Class for buffered reading int and double values
     */
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}


