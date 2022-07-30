//Problem: https://codeforces.com/contest/1118/problem/A

import java.io.*;
import java.util.*;

public class water {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = next(1);
        for (int t = 1; t <= T; t++) {
            long n = Long.parseLong(next()); int a = next(1), b = next(1);
            out.println(n / 2 * Math.min(2*a, b) + a * (n % 2));
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
