//Problem 5

import java.io.*;
import java.util.*;

public class Goro {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("goro.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int x = Integer.parseInt(br.readLine());
            double sum = 0;
            for (int i = 1; i <= x; i++) {
                double thinkies = 1.0 / ((2.0 * i - 1) * Math.pow(3.0, i-1));
                sum += i % 2 == 0 ? -1 * thinkies : thinkies;
                out.printf("%.5f%n", Math.sqrt(12) * sum);
            }
        }
        br.close(); out.close();
    }
}
