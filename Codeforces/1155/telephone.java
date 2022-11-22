//Problem: https://codeforces.com/contest/1155/problem/B

import java.io.*;
import java.util.*;

public class telephone {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            String s = next();
            int vas = (n-11)/2, pet = vas;
            String res = "";
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '8') {
                    if (vas > 0) --vas;
                    else res += s.charAt(i);
                } else {
                    if (pet > 0) --pet;
                    else res += s.charAt(i);
                }
            }
            out.println(res.charAt(0) == '8' ? "YES" : "NO");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
