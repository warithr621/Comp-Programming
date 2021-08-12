//Problem: https://codeforces.com/contest/1547/problem/A
//Note: In-Contest Submission

import java.io.*;
import java.util.*;

public class short_path {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int xa = Integer.parseInt(next()), ya = Integer.parseInt(next()), xb = Integer.parseInt(next()), yb = Integer.parseInt(next()), xf = Integer.parseInt(next()), yf = Integer.parseInt(next());
            if (xa == xb && xb == xf) {
                if (Math.min(ya, yb) < yf && yf < Math.max(ya, yb)) out.println(Math.abs(ya-yb) + 2);
                else out.println(Math.abs(ya-yb));
            } else if (ya == yb && yb == yf) {
                if (Math.min(xa, xb) < xf && xf < Math.max(xa, xb)) out.println(Math.abs(xa-xb) + 2);
                else out.println(Math.abs(xa-xb));
            } else out.println(Math.abs(xa-xb) + Math.abs(ya-yb));
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
