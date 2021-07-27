//Problem 2

import java.io.*;
import java.util.*;

public class Barb {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("barb.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int x = Integer.parseInt(br.readLine());
            out.println("A   A*A   3*A   A/2");
            for (int i = 1; i<= x; i++) out.printf("%d     %d     %d     %d%n", i, i*i, 3*i, i/2);
        }
        br.close(); out.close();
    }
}
