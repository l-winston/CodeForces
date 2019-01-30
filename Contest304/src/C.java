import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        init(System.in);

        int n = nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }

        for (int i = 0; i < n; i++) {
            a[i] = i;
            b[i] = (i + 1) % n;
            c[i] = (a[i] + b[i])%n;
            hashSet.remove(c[i]);
        }

        if(!hashSet.isEmpty()){
            System.out.println(-1);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            stringBuilder.append(a[i] + " ");
        }
        for(int i = 0; i < n; i++){
            stringBuilder.append(b[i] + " ");
        }
        for(int i = 0; i < n; i++){
            stringBuilder.append(c[i] + " ");
        }

        System.out.println(stringBuilder.toString());
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


