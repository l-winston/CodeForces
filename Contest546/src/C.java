import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class C {
    public static void main(String[] args) throws IOException {
        init(System.in);
        int n =  nextInt();

        HashSet<State> states = new HashSet<>();

        int alen = nextInt();
        Queue<Integer> a = new LinkedList<>();
        for (int i = 0; i < alen; i++) {
            int x = nextInt();
            a.add(x);
        }


        int blen = nextInt();
        Queue<Integer> b = new LinkedList<>();
        for (int i = 0; i < blen; i++) {
            b.add(nextInt());
        }

        int fights = 0;

        while(true){

            State curr = new State(new ArrayList<Integer>(a), new ArrayList<Integer>(b));

            if(states.contains(curr)){
                System.out.println(-1);
                return;
            }

            states.add(curr);

            int card1 = a.remove();
            int card2 = b.remove();

            if(card1 > card2){
                a.add(card2);
                a.add(card1);
            }else{
                b.add(card1);
                b.add(card2);
            }

            fights++;

            if(a.isEmpty() || b.isEmpty())
                break;
        }

        System.out.println(fights);
        System.out.println(a.isEmpty() ? 2 : 1);

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


class State{
    ArrayList<Integer> a;
    ArrayList<Integer> b;

    public State(ArrayList<Integer> a, ArrayList<Integer> b){
        this.a = a;
        this.b = b;
    }

    public int hashCode(){
        return a.hashCode() * b.hashCode();
    }

    public boolean equals(Object o){
        State s = (State) o;
        return a.equals(s.a) && b.equals(s.b);
    }
}
