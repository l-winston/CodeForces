import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt(), l = Reader.nextInt(), r = Reader.nextInt();

        int[][] dp = new int[3][n];

        dp[0][0] = dp[1][0] = dp[2][0] = (r-l+1)/3;

        switch ((r-l+1) % 3){
            case 0:
                break;
            case 1:
                dp[l%3][0]++;
                break;
            case 2:
                dp[l%3][0]++;
                dp[(l+1)%3][0]++;
                break;
        }


        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                for(int k = j; k < 3; k++){
                    dp[(j+k)%3][i] += dp[j][i-1]*dp[k][i-1];
                }
            }
        }
        for(int[] i : dp)
            System.out.println(Arrays.toString(i));
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


