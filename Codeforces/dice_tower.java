//Problem: https://codeforces.com/contest/1266/problem/B

import java.io.*;
import java.util.*;

public class dice_tower {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = next(1);
        for (int ttt = 1; ttt <= T; ttt++) {
            long n = Long.parseLong(next());
            out.println(n / 14 >= 1 && 1 <= n%14 && n%14 <= 6 ? "YES" : "NO");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int next(int x) throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}
