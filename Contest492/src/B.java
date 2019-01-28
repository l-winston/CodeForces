import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n = nextInt();
        int l = nextInt();

        int[] lanterns = new int[n];
        for (int i = 0; i < n; i++) {
            lanterns[i] = nextInt();
        }
        Arrays.sort(lanterns);

        int[] dists = new int[n+1];
        dists[0] = 2*lanterns[0];
        dists[n] = 2*(l - lanterns[n-1]);

        for(int i = 1; i < n; i++){
            dists[i] = lanterns[i] - lanterns[i-1];
        }

        int max = -1;

        for(int i : dists)
            max = Math.max(max, i);


        System.out.println(new BigDecimal(max).divide(new BigDecimal(2)));
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


