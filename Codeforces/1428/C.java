//Problem: https://codeforces.com/contest/1428/problem/C

import java.io.*;
import java.util.*;

public class abbb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            String s = next(); int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'B' && ans > 0) --ans;
                else ++ans;
            }
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}