//Problem: https://codeforces.com/gym/103158/problem/J

import java.io.*;
import java.util.*;

public class two2 {
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("two2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // static StringTokenizer st = new StringTokenizer("");
    	T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            out.println(n % 2 == 1 ? -1 : n/2);
        }
        br.close(); out.close();
    }
}