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
        int a = nextInt() - 1;

        int ans = 0;

        boolean[] criminal = new boolean[n];

        for (int i = 0; i < n; i++) {
            criminal[i] = nextInt() == 1;
            if(criminal[i])
                ans++;
        }

        for(int i = 0; i < n; i++){
            if(!criminal[i])
                continue;
            int dif = a-i;
            if(a+dif >= 0  && a + dif < n) {
                if (!criminal[a + dif])
                    ans--;
            }
        }

        System.out.println(ans);
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


