// 2019 Feb Silver P2

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class PaintBarnSilver {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st = new StringTokenizer("");
    static int nexti() throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("paintbarn.in"));
        out = new PrintWriter("paintbarn.out");
        int n = nexti(), k = nexti();
        int[][] p = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            int x1 = nexti(), y1 = nexti(), x2 = nexti(), y2 = nexti();
            ++x1; ++x2; ++y1; ++y2;
            p[x1][y1]++;
            p[x2][y2]++;
            p[x2][y1]--;
            p[x1][y2]--;
        }
        int ans = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                p[i][j] = p[i][j] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
                if (p[i][j] == k) ++ans;
            }
        }
        out.println(ans);
        br.close(); out.close();
    }
}