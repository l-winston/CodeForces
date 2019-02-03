import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class C {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n = nextInt();

        HashMap<Integer, Integer> xs = new HashMap<>();
        HashMap<Integer, Integer> ys = new HashMap<>();
        HashMap<Point, Integer> points = new HashMap<Point, Integer>();

        int pairs = 0;

        for(int i = 0; i < n; i++){
            int x = nextInt();
            int y = nextInt();
            Point p = new Point(x, y);

            if(xs.containsKey(x))
                xs.put(x, xs.get(x)+1);
            else
                xs.put(x, 1);

            if(ys.containsKey(y))
                ys.put(y, ys.get(y)+1);
            else
                ys.put(y, 1);

            if(points.containsKey(p))
                points.put(p, points.get(p)+1);
            else
                points.put(p, 1);
        }

        for(int i : xs.keySet()) {
            int k = xs.get(i);
            pairs += k*(k-1)/2;
        }

        for(int i : ys.keySet()) {
            int k = ys.get(i);
            pairs += k*(k-1)/2;
        }

        for(Point p : points.keySet()){
            int k = points.get(p);
            pairs -= k*(k-1)/2;
        }

        System.out.println(pairs);1
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

    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}

class Point{
    public int x, y;
    public Point(int x_, int y_){
        x = x_;
        y = y_;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return x == p.x && y == p.y;
    }
}


