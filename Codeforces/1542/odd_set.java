//Problem: https://codeforces.com/contest/1542/problem/A

import java.io.*;
import java.util.*;

public class odd_set {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            int odd = 0, even = 0;
            for (int i = 0; i < 2*n; i++) {
                if (Integer.parseInt(next()) % 2 == 0) ++even;
                else ++odd;
            }
            out.println(even == odd ? "Yes" : "no");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
