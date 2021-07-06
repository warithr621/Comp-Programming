//Problem: https://codeforces.com/contest/1117/problem/A

import java.io.*;
import java.util.*;

public class best_subseg {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), mx = -1;
            String s = "";
            for (int i = 0; i < n; i++) {
                String temp = next();
                s += temp + " ";
                mx = Math.max(mx, Integer.parseInt(temp));
            }
            String find = Integer.toString(mx);
            while(s.contains(find)) find += " " + Integer.toString(mx);
            out.println(find.split(" ").length - 1);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
