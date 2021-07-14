//Problem: https://codeforces.com/contest/1550/problem/A

import java.io.*;
import java.util.*;

public class find_array {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            out.println((int)Math.ceil(Math.sqrt(Integer.parseInt(next()))));
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
