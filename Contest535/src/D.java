import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class D {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        char[] garland = Reader.next().toCharArray();
        int x = 0;
        for(int i = 1; i < n-1; i++){
            char oth = findOther(garland[i-1], garland[i+1]);
            if(garland[i] != oth)
        }

    }

    static char findOther(char a, char b){
        return getChar(3-getInt(a)-getInt(b));
    }

    static int getInt(char c){
        switch (c){
            case 'R':
                return 0;
            case 'G':
                return 1;
            case 'B':
                return 2;
        }
        return -1;
    }

    static char getChar(int i){
        switch (i){
            case 0:
                return 'R';
            case 1:
                return 'G';
            case 2:
                return 'B';
        }
        return 'E';
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


