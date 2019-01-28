import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B {
    public static void main(String[] args) throws IOException {
        init(System.in);

        char[][] matrix = new char[3][3];

        for (int i = 0; i < 3; i++) {
            String s = next();
            int a = s.charAt(0) - 'A';
            int b = s.charAt(2) - 'A';
            char relation = s.charAt(1);
            matrix[a][b] = relation;
            matrix[b][a] = relation == '<' ? '>' : '<';
        }

        int numMiddle = 0;

        for (int i = 0; i < 3; i++) {
            int target = '<' + '>';
            int sum = 0;
            for(int j = 0; j < 3; j++){
                sum += matrix[i][j];
            }
            if(target == sum)
                numMiddle++;
        }

        if(numMiddle != 1) {
            System.out.println("Impossible");
            return;
        }

        char[] ans = new char[3];

        for (int i = 0; i < 3; i++) {
            int lowest = '<' + '<';
            int middle = '<' + '>';
            int highest = '>' + '>';

            int sum = 0;
            for(int j = 0; j < 3; j++){
                sum += matrix[i][j];
            }

            if(sum == lowest)
                ans[0] = (char) ('A' + i);
            else if(sum == middle)
                ans[1] = (char) ('A' + i);
            else
                ans[2] = (char) ('A' + i);
        }

        for(char c : ans)
            System.out.print(c);

        System.out.println();
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


