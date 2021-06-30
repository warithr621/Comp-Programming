//Problem: https://atcoder.jp/contests/abc205/tasks/abc205_b

import java.io.*;
import java.util.*;

public class permutation_check {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i = 0; i < n; i++) hs.add(Integer.parseInt(next()));
            out.println(hs.size() == n ? "Yes" : "No");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
