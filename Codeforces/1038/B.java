//Problem: https://codeforces.com/contest/1038/problem/B

import java.io.*;
import java.util.*;

public class non_coprime {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            if (n <= 2) out.println("No");
            else {
                out.println("Yes");
                int k = (n % 2 == 0 ? n/2 : (n+1) / 2);
                out.println(1 + " " + k);
                out.print(n-1);
                for (int i = 1; i <= n; i++) {
                    if (i != k) out.print(" " + i);
                }
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
