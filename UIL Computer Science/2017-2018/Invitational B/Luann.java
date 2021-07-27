//Problem 8

import java.io.*;
import java.util.*;

public class Luann {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("luann.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            int x = Integer.parseInt(br.readLine());
            char[][] mat = new char[x+1][x+1];
            for (int i = 0; i < x+1; i++) Arrays.fill(mat[i], ' ');
            for (int i = 0; i < x; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                mat[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 'X';
            }
            for (int i = x; i >= 1; i--) {
                out.print(i + "|");
                for (int j = 1; j <= x; j++) out.print(mat[j][i]);
                out.println();
            }
            out.print("  ");
            for (int i = 0; i < x; i++) out.print("_");
            out.print("\n  ");
            for (int i = 1; i <= x; i++) out.print(i);
            out.println("\n=====");
        }
        br.close(); out.close();
    }
}
