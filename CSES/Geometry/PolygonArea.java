// CSES Polygon Area

import java.util.*;
import java.io.*;
 
public class PolygonArea {
    static String a,b;
    static StringTokenizer st = new StringTokenizer("");
    static BufferedReader br; static PrintWriter out;
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int n = nexti();
        int[][] a = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nexti();
            a[i][1] = nexti();
        }
        a[n][0] = a[0][0];
        a[n][1] = a[0][1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += 1L * a[i-1][0] * a[i][1] - 1L * a[i-1][1] * a[i][0];
            // out.println(ans);
        }
        out.println(Math.abs(ans));
        br.close(); out.close();
    }
    static String next() throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nexti() throws IOException {
        return Integer.parseInt(next());
    }
}