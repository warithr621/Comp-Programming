//Problem: https://codeforces.com/contest/1324/problem/C

import java.io.*;
import java.util.*;

public class frog {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = nexti();
        for (int ttt = 1; ttt <= T; ttt++) {
            String s = next();
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(-1);
            for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'R') al.add(i);
            al.add(s.length());
            int ans = -1;
            for (int i = 1; i < al.size(); i++) ans = Math.max(ans, al.get(i) - al.get(i-1));
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nexti() throws IOException {
        return Integer.parseInt(next());
    }
}
