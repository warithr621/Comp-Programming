//Problem: https://codeforces.com/contest/441/problem/A

import java.io.*;
import java.util.*;

public class antique {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), k = Integer.parseInt(next());
            TreeSet<Integer> ts = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(next());
                while(x-->0) {
                    if (k > Integer.parseInt(next())) ts.add(i+1);
                }
            }
            out.println(ts.size());
            for (int i : ts) out.print(i + " ");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
