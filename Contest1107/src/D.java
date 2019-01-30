import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class D {
    private static String[] staticLookup = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static String HexToBinary(char Hex) {
        return staticLookup[Integer.parseInt(Character.toString(Hex), 16)];
    }

    public static void main(String[] args) throws IOException {
        init(System.in);

        int n = nextInt();

        boolean[][] ar = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            char[] chars = next().toCharArray();

            for (int j = 0; j < n / 4; j++) {

                String s = HexToBinary(chars[j]);

                for (int k = 0; k < 4; k++) {
                    ar[i][j * 4 + k] = s.charAt(k) == '1';
                }
            }
        }

        //for (boolean[] b : ar)
            //System.out.println(Arrays.toString(b));


        HashSet<Integer> consec = new HashSet<>();

        for (int i = 0; i < n; i++) {
            boolean last = ar[i][0];
            int curr = 1;
            for (int j = 1; j < n; j++) {
                if (ar[i][j] == last)
                    curr++;
                else {
                    consec.add(curr);
                    curr = 1;
                    last = ar[i][j];
                }
            }
            consec.add(curr);
        }

        for (int i = 0; i < n; i++) {
            boolean last = ar[0][i];
            int curr = 1;
            for (int j = 1; j < n; j++) {
                if (ar[j][i] == last)
                    curr++;
                else {
                    consec.add(curr);
                    curr = 1;
                    last = ar[j][i];
                }
            }
            consec.add(curr);
        }

        //  System.out.println(consec);

        int ans = 0;

        for (int i : consec)
            ans = gcd(ans, i);

        System.out.println(ans);

    }

    static int pow(int x) {
        int ans = 1;
        for (int i = 0; i < x; i++)
            ans *= 10;
        return ans;
    }

    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
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

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}


