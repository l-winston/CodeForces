import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        String topLeft = "1 1";
        String bottomLeft = "3 1";
        String topRight = "1 3";

        char[] pieces = Reader.next().toCharArray();

        boolean bl = false;
        boolean tr = false;
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == '0') {
                if(bl){
                    System.out.println(topLeft);
                }else{
                    System.out.println(bottomLeft);
                }
                bl = !bl;
            } else {
                if(tr){
                    System.out.println(topLeft);
                }else{
                    System.out.println(topRight);
                }
                tr = !tr;
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


