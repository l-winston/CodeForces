import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);

        int sum = nextInt();
        int limit = nextInt();

        int k = 0;
        int count = 0;

        while(sum >= 1 << ++k);

        k--;

        if(1<<k > limit){
            System.out.println(-1);
            return;
        }

        StringBuilder S = new StringBuilder();

        for(int i = k; i >= 0; i--){
            if(1<<i <= sum) {
                sum -= 1 << i;
                S.append((1<<i) + " ");
                count++;
            }
        }

        System.out.println(count);
        System.out.println(S);
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

    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}


