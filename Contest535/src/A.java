import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int q = Reader.nextInt();

        qloop:
        for(int i = 0; i < q; i++){
            int a1 = Reader.nextInt();
            int b1 = Reader.nextInt();
            int a2 = Reader.nextInt();
            int b2 = Reader.nextInt();


            System.out.print(a1 + " ");

            for(int j = a2; j <= b2; j++) {
                if (j != a1) {
                    System.out.println(j);
                    continue qloop;
                }
            }
        }
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


