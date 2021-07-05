//Problem: https://atcoder.jp/contests/agc054/tasks/agc054_a

import java.io.*;
import java.util.*;
 
public class remove_sub {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            String s = next();
            if (s.charAt(0) != s.charAt(n-1)) out.println(1);
            else if (exist(s)) out.println(2);
            else out.println(-1);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static boolean exist(String s) {
        for (int i = 1; i < s.length()-2; i++) if (s.charAt(0) != s.charAt(i) && s.charAt(0) != s.charAt(i+1)) return true;
        return false;
    }
}
