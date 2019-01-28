import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {

        init(System.in);

        int n = nextInt();

        StringBuilder ans = new StringBuilder();
        char[] num = next().toCharArray();
        ArrayList<Integer> factors = new ArrayList<>();
        for (char c : num) {
            for (int i = 2; i <= c - '0'; i++)
                factors.addAll(getFactors(i));
        }

        for (int i = 9; i >= 2; i--) {
            while(factors.contains(i)){
                ans.append(i);

                for(int j = 2; j <= i; j++){
                    for(int k : getFactors(j))
                        factors.remove(new Integer(k));
                }
            }
        }

        System.out.println(ans.toString());
    }

    static ArrayList<Integer> getFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        int f = 2;
        while (n != 1) {
            while (n % f == 0) {
                factors.add(f);
                n /= f;
            }
            f++;
        }
        return factors;
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


