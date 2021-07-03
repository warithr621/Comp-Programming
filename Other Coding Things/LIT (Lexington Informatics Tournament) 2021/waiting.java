import java.io.*;
import java.util.*;

public class waiting {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(next()), M = Integer.parseInt(next()), L = Integer.parseInt(next());
            int lim = 0, ans = 0;
            Queue<Integer> q = new PriorityQueue<Integer>();
            while(N-->0) {
                int inp = Integer.parseInt(next());
                int end = -1;
                while(q.size() > 0 && q.peek() < inp) {
                    --lim;
                    end = q.poll();
                }
                if (end != -1 && lim == 0) {
                    ans += inp - end - 1;
                }
                if (lim == L) {
                    q.offer(q.peek() + M);
                    q.poll();
                }
                if (lim < L) {
                    q.offer(inp + M - 1);
                    ++lim;
                }
            }
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
