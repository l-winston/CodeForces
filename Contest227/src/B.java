import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n = nextInt();
        int[] numbers = new int[n];
        HashMap<Integer, Integer> elemToPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numbers[i] = nextInt();
            elemToPos.put(numbers[i], i);
        }

        int m = nextInt();
        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            queries[i] = nextInt();
        }


        long c1 = 0;
        long c2 = 0;

        for (int i = 0; i < m; i++) {
            int query = queries[i];

            if (elemToPos.containsKey(query)) {
                int ind = elemToPos.get(query);
                c1 += 1 + ind;
                c2 += n - ind;
            } else {
                c1 += n;
                c2 += n;
            }
        }

        System.out.println(c1 + " " + c2);
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


