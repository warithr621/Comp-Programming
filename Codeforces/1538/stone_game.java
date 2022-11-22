//Problem: https://codeforces.com/problemset/problem/1538/A

import java.io.*;
import java.util.*;

public class stone_game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            int[] a = new int[n];
            int low = 0, high = 0;
            for (int i = 0; i < n; i++) {
                a[i] = next(1);
                if (a[i] < a[low]) low = i;
                if (a[i] > a[high]) high = i;
            }
            int[] options = {Math.max(low, high) + 1, n - Math.min(low, high), n - high + low + 1, n - low + high + 1};
            Arrays.sort(options);
            out.println(options[0]);
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
