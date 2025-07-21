//Problem: https://codeforces.com/contest/1413/problem/A

import java.io.*;
import java.util.*;

public class sasuke {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = next(1);
            for (int i = 0; i < n-1; i+=2) out.printf("%d %d ", -1 * a[i+1], a[i]);
            out.println();
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