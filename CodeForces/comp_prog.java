//Problem: https://codeforces.com/contest/1266/problem/A

import java.io.*;
import java.util.*;

public class comp_prog {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = next(1);
        for (int ttt = 1; ttt <= T; ttt++) {
            char[] s = next().toCharArray();
            Arrays.sort(s);
            boolean zero = s[0] == '0' ? true : false;
            boolean even = false;
            int sum = 0;
            for (int i = 1; i < s.length; i++) {
                int dig = s[i] - '0';
                if (dig % 2 == 0) even = true;
                sum += dig;
            }
            out.println(zero && even && sum % 3 == 0 ? "red" : "cyan");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int next(int x) throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}
