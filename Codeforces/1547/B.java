//Problem: https://codeforces.com/contest/1547/problem/B
//Note: In-Contest Submission

import java.io.*;
import java.util.*;

public class alpha_string {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            String s = next();
            int idx = s.indexOf('a');
            if (idx == -1) out.println("nO");
            else {
                char current = 'b';
                boolean x = true;
                int left = idx-1, right = idx+1;
                while(current < 'a' + s.length() && x) {
                    if (find(s, left) == current && find(s, right) == current) {
                        if (x) out.println("nO"); x = false;
                    } else if (find(s, left) == current) {--left; ++current;}
                    else if (find(s, right) == current) {++right; ++current;}
                    else {
                        if (x) out.println("NO"); x = false;
                    }
                }
                if (x) out.println("YEs");
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static char find(String s, int i) {
        if (i < 0 || i >= s.length()) return '!';
        return s.charAt(i);
    }
}
