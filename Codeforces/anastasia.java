//Problem: https://codeforces.com/contest/789/problem/A

import java.io.*;
import java.util.*;

public class anastasia {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), k = Integer.parseInt(next()), sum = 0;
            while(n-->0) sum += (Integer.parseInt(next()) + k - 1) / k;
            out.println(++sum / 2);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
