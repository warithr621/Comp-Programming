//Problem 8

import java.io.*;
import java.util.*;

public class Lucie {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lucie.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            int[][] a = new int[r+1][c+1];
            for(int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine(), ",");
                for (int j = 0; j < r; j++) a[j][i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < r; i++) {
                int sum = 0;
                for (int j = 0; j < c; j++) sum += a[i][j];
                a[i][c] = sum;
            }
            for (int j = 0; j < c; j++) {
                int sum = 0;
                for (int i = 0; i < r; i++) sum += a[i][j];
                a[r][j] = sum;
            }
            for (int i = 0; i < r+1; i++) {
                String ret = Integer.toString(a[i][0]);
                for (int j = 1; j < (i == r ? c : c+1); j++) {
                    ret += "," + Integer.toString(a[i][j]);
                }
                out.println(ret);
            }
            out.println("************");
        }
        br.close(); out.close();
    }
}
