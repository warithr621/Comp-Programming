//Problem: https://codeforces.com/contest/1547/problem/C

import java.io.*;
import java.util.*;

public class pair_prog {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(next()), n = Integer.parseInt(next()), m = Integer.parseInt(next());
            int[] a = new int[n], b = new int[m];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(next());
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(next());
            int posa = 0, posb = 0;
            boolean good = true;
            ArrayList<Integer> ans = new ArrayList<Integer>();
            while(posa != n || posb != m) {
                if (posa != n && a[posa] == 0) {
                    ans.add(0);
                    ++k; ++posa;
                } else if (posb != m && b[posb] == 0) {
                    ans.add(0);
                    ++k; ++posb;
                } else if (posa != n && a[posa] <= k) ans.add(a[posa++]);
                else if (posb != m && b[posb] <= k) ans.add(b[posb++]);
                else {
                    out.println(-1);
                    good = false;
                    break;
                }
            }
            if (good) {
                for (int i : ans) out.print(i + " ");
                out.println();
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
