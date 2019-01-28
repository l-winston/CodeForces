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
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = nextInt();
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);


        for(int i = 1; i < n; i++){

            if(heights[i] >= heights[i-1])
                left[i] += left[i-1];
        }

        for(int i = n-2; i >= 0; i--){

            if(heights[i] >= heights[i+1])
                right[i] += right[i+1];

        }

        int maxi = -1;
        int max = -1;

        for(int i = 0; i < n; i++){
            if(left[i] + right[i] - 1 > max) {
                maxi = i;
                max = left[i] + right[i] - 1;
            }
        }

        System.out.println(max);

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


