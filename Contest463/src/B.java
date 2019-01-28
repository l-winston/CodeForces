import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n = nextInt();
        int[] heights = new int[n+1];
        for (int i = 1; i < n+1; i++) {
             heights[i] = nextInt();
        }

        int min = Integer.MAX_VALUE;
        int current = 0;
        for(int i = 1; i < n+1; i++){
            current += heights[i-1] - heights[i];
            min = Math.min(min, current);
        }

        System.out.println(Math.max(0, -min));
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


