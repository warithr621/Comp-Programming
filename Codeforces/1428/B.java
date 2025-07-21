// Problem: https://codeforces.com/contest/1428/problem/B

import java.io.*;
import java.util.*;

public class belt_room {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            String s = next(); s += s.charAt(0);
            boolean cw = false, ccw = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '<') cw = true;
                if (s.charAt(i) == '>') ccw = true;
            }
            if (cw && ccw) {
                int ans = 0;
                for (int i =0; i < n; i++) if (s.charAt(i) == '-' || s.charAt(i+1) == '-') ++ans;
                out.println(ans);
            } else out.println(n);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}