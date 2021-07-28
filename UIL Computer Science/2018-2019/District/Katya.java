//Problem 7

import java.io.*;
import java.util.*;

public class Katya {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("katya.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()), c1 = Integer.parseInt(st.nextToken()), r2 = Integer.parseInt(st.nextToken()), c2 = Integer.parseInt(st.nextToken());
            int[][] a = new int[r1][c1];
            int[][] b = new int[r2][c2];
            for (int i = 0; i < r1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c1; j++) a[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < r2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c2; j++) b[i][j] = Integer.parseInt(st.nextToken());
            }
            if (c1 != r2) {
                out.printf("%d:SIZES NOT COMPATIBLE\n^^^^^^^^^^^^\n", tt);
                continue;
            }
            out.printf("%d:%d,%d%n", tt, r1, c2);
            int[][] prod = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    int sum = 0;
                    for (int k = 0; k < c1; k++) sum += a[i][k] * b[k][j];
                    prod[i][j] = sum;
                }
            }
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) out.printf("%5d", prod[i][j]);
                out.println();
            }
            out.println("^^^^^^^^^^^^");
        }
        br.close(); out.close();
    }
}
