//Problem: https://codeforces.com/contest/1092/problem/A

import java.io.*;
import java.util.*;

public class uni_string {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1), k = next(1);
            int[] a = new int[k];
            int sum = 0;
            for (int i = 0; i < k; i++) a[i] = n/k;
            sum = n/k*k;
            for (int i = 0; i < n-sum; i++) ++a[i];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < a[i]; j++) out.print((char) (i + 97));
            }
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