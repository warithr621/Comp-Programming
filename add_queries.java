//Problem: https://codeforces.com/gym/103150/problem/A

import java.io.*;
import java.util.*;

public class add_queries {
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // static StringTokenizer st = new StringTokenizer("");
    	T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            out.println(a[n-1] - a[0]);
        }
        br.close(); out.close();
    }
}