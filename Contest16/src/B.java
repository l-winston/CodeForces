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
        int m = nextInt();

        Container[] containers = new Container[m];

        for (int i = 0; i < m; i++) {
            containers[i] = new Container(nextInt(), nextInt());
        }

        Arrays.sort(containers);

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (containers[i].boxes <= n) {
                ans += containers[i].boxes * containers[i].perbox;
                n -= containers[i].boxes;
            } else {
                ans += n * containers[i].perbox;
                n = 0;
            }
            if (n == 0){
                break;
            }
        }
        System.out.println(ans);
    }

    static class Container implements Comparable<Container> {
        int boxes;
        int perbox;

        public Container(int b, int p) {
            boxes = b;
            perbox = p;
        }

        public int compareTo(Container c) {
            return c.perbox - perbox;
        }

        public String toString() {
            return boxes + " " + perbox;
        }
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


