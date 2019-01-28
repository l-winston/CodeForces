import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n = nextInt();
        char[] colors = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};

        char[] out = new char[n];

        for (int i = 0; i < Math.min(7, n); i++) {
            out[i] = colors[i % 7];
        }

        for(int i = 7; i < n; i++){
            out[i] = out[i-4];
        }

        System.out.println(new String(out));
    }

    /**
     * buffered reading int and double values
     */
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


