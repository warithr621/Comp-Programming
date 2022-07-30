//Problem: https://codeforces.com/contest/583/problem/A

import java.io.*;
import java.util.*;

public class asphalt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int t = 1; t <= T; t++) {
            int N = next(1);
            boolean[][] a = new boolean[N][2];
            for (int i = 0; i < N; i++) Arrays.fill(a[i], false);
            for (int i = 0; i < N*N; i++) {
                int x = next(1), y = next(1);
                if (!a[--x][0] && !a[--y][1]) {
                    out.print(i + 1 + " ");
                    a[x][0] = true;
                    a[y][1] = true;
                }
            }
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
