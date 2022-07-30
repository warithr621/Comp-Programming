//Problem: https://codeforces.com/gym/103158/problem/A

import java.io.*;
import java.util.*;

public class alimagde {
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("alimagde.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // static StringTokenizer st = new StringTokenizer("");
    	T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long n = Long.parseLong(br.readLine());
            long thinkies = (long) ((-1 + Math.sqrt(1 + 8L*n)) / 2);
            out.println(n - thinkies);
        }
        br.close(); out.close();
    }
}