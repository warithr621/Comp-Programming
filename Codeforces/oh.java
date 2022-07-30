//Problem: https://codeforces.com/gym/103150/problem/E

import java.io.*;
import java.util.*;

public class oh {
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // static StringTokenizer st = new StringTokenizer("");
    	T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            br.readLine(); br.readLine();
            String b = br.readLine();
            o(b);
        }
        br.close(); out.close();
    }
    static void o(String s) {
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'o') {System.out.println("YES"); return;}
        System.out.println("NO");
    }
}