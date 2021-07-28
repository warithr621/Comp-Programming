//Problem 12

import java.io.*;
import java.util.*;

public class Vova {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("vova.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
            int diff = Math.abs(c-a) + Math.abs(d-b);
            out.printf("Case #%d: %s%n", tt, L % 2 == diff % 2 && (L - diff) >= 0 ? "YES" : "NO");
        }
        br.close(); out.close();
    }
}
