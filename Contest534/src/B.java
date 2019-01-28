import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        char[] c = Reader.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(c[0]);
        int count = 0;
        for(int i = 1; i < c.length; i++){
            if(!stack.isEmpty() && stack.peek() == c[i]){
                count++;
                stack.pop();
            }else{
                stack.push(c[i]);
            }
        }

        System.out.println(count%2 != 0 ? "Yes" : "No");
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


