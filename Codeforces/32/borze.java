//Problem: https://codeforces.com/problemset/problem/32/B

import java.io.*;
import java.util.*;

public class borze {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            out.println(zero(one(two(next()))));
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static String zero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') s = s.substring(0, i) + "0" + s.substring(i+1);
        }
        return s;
    }
    static String one(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '-' && s.charAt(i+1) == '.') s = s.substring(0, i) + "1" + s.substring(i+2);
        }
        return s;
    }
    static String two(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '-' && s.charAt(i+1) == '-') s = s.substring(0, i) + "2" + s.substring(i+2);
        }
        return s;
    }
}
