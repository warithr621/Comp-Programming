// https://codeforces.com/problemset/problem/1201/C

import java.io.*;
import java.util.*;
public class Max_Median {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in)); 
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (T-->0) {
            int n = nexti(), k = nexti();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nexti();
            Arrays.sort(a);
            long L = a[n / 2], R = L + k, mid = 0;
            while (L < R) {
                mid = (L + R + 1) / 2;
                long sum = 0;
                for (int i = n / 2; i < n; i++) sum += Math.max(0, mid - a[i]);
                if (sum <= k) L = mid;
                else R = mid - 1;
            }
            out.println(L);
        }
        br.close();
        out.close();
    }
    static String next() throws IOException {
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nexti() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextl() throws IOException {
        return Long.parseLong(next());
    }
    static double nextd() throws IOException {
        return Double.parseDouble(next());
    }
}
