//Problem 4

import java.io.*;
import java.util.*;

public class Dawn {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("dawn.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int n = Integer.parseInt(br.readLine());
            double inv = 0, pay = 0, total = 0, profit = 0;
            out.println("     Amount                             Monthly         Total of");
            out.println("....Invested........APR......Years......Payment.........Payments............Profit..");
            while(n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double a = Double.parseDouble(st.nextToken()), apr = Double.parseDouble(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                inv += a;
                double r = apr / 1200;
                double month = round(a * r / (1 - Math.pow(1 + r, -12 * y)));
                double temp = round(month * 12 * y);
                double PR = round(temp - a);
                pay += month;
                total += temp;
                profit += PR;
                out.printf("$%,12.2f  | %7.3f%%  |   %2d  |  $ %,8.2f  |  $%,12.2f  |  $%,12.2f%n", a, apr, y, month, temp, PR);
            }
            out.printf("$%,12.2f  |           |       |  $ %,8.2f  |  $%,12.2f  |  $%,12.2f%n", inv, pay, total, profit);
        }
        br.close(); out.close();
    }
    static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
}
