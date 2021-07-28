//Problem 4

import java.io.*;
import java.util.*;

public class Dawn {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("dawn.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int n = Integer.parseInt(br.readLine());
            double inv = 0, pay = 0, total = 0, profit = 0;
            out.println("     Amount                             Monthly         Total of");
            out.println("....Invested........APR......Years......Payment.........Payments............Profit..");
            while(n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double a = Double.parseDouble(st.nextToken()), b = Double.parseDouble(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                inv += a;
                double mon;
            }
        }
        br.close(); out.close();
    }
}
