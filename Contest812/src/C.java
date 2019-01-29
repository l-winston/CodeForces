import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        init(System.in);

        int n = nextInt();
        int s = nextInt();

        Souvenir[] souvenirs = new Souvenir[n];

        for (int i = 0; i < n; i++) {
            souvenirs[i] = new Souvenir(nextInt(), i+1);
        }

        int low = 0;
        int high = n;

        while (low < high) {
            int mid = (low + high) / 2 + 1;
            if (eval(souvenirs, mid) <= s)
                low = mid;
            else
                high = mid - 1;

        }

        System.out.println(low + " " + eval(souvenirs, low));
    }

    static long eval(Souvenir[] souvenirs, int k) {
        Souvenir.k = k;

        Arrays.sort(souvenirs);

        long ans = 0;
        for(int i = 0; i < k; i++){
            ans += souvenirs[i].cost();
        }

        return ans;
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

class Souvenir implements Comparable<Souvenir> {
    static int k;

    int base, index;

    public Souvenir(int b, int i) {
        base = b;
        index = i;
    }

    public long cost(){
        return base + k*index;
    }

    @Override
    public int compareTo(Souvenir o) {
        return (int) (cost() - o.cost());
    }
}


