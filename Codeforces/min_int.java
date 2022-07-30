//Problem: https://codeforces.com/contest/1101/problem/A

import java.io.*;
import java.util.*;

public class min_int {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int L = Integer.parseInt(next()), R = Integer.parseInt(next()), D = Integer.parseInt(next());
            int low = (int) Math.ceil(L * 1.0 / D), high = (int) Math.floor(R * 1.0 / D);
            out.println(low == 1 ? D * (high+1) : D);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
