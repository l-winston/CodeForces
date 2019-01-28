import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();

        char[] lights = Reader.next().toCharArray();
        char[][] patts = {{'R', 'G', 'B'}, {'R', 'B', 'G'}, {'B', 'G', 'R'}, {'B', 'R', 'G'}, {'G', 'B', 'R'}, {'G', 'R', 'B'}};

        int best = -1;
        int minScore = Integer.MAX_VALUE;

        for(int i = 0; i < patts.length; i++){


            int score = 0;
            for(int j = 0; j < n; j++){
                if(lights[j] != patts[i][j%3]){
                    score ++;
                }
            }

            if(score < minScore) {
                best = i;
                minScore = score;
            }
        }

        System.out.println(minScore);
        char[] ans = new char[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = patts[best][i%3];
        }
        System.out.println(new String(ans));
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


