//Problem: https://codeforces.com/contest/1428/problem/A

import java.io.*;
import java.util.*;

public class box {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int a = Integer.parseInt(next()), b = Integer.parseInt(next()), c = Integer.parseInt(next()), d = Integer.parseInt(next());
            int ans = Math.abs(a-c) + Math.abs(b-d);
            out.println(a == c || b == d ? ans : ans+2);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}