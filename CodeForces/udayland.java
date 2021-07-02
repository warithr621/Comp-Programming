//Problem: https://codeforces.com/problemset/problem/711/A

import java.io.*;
import java.util.*;

public class udayland {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            String[] a = new String[n];
            boolean b = false;
            for (int i = 0; i < n; i++) {
                a[i] = next();
                if (a[i].charAt(0) == 'O' && a[i].charAt(1) == 'O') {
                    if (!b) a[i] = "++|" + a[i].substring(3);
                    b = true;
                } else if (a[i].charAt(3) == 'O' && a[i].charAt(4) == 'O') {
                    if (!b) a[i] = a[i].substring(0,3) + "++";
                    b = true;
                }
            }
            if (!b) out.println("NO");
            else {
                out.println("YES");
                for (String s : a) out.println(s);
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
