//Problem: https://codeforces.com/gym/103158/problem/L

import java.io.*;
import java.util.*;

public class max-pair {
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("max-pair.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // static StringTokenizer st = new StringTokenizer("");
    	T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String a = br.readLine();
            int cnt = a.length()-1;
            while(a.charAt(0) == a.charAt(cnt) && cnt != 0) --cnt;
            out.println((cnt == 0 ? 0 : cnt));
        }
        br.close(); out.close();
    }
}