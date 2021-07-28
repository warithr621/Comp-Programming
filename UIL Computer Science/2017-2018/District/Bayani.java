//Problem 2

import java.io.*;
import java.util.*;

public class Bayani {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("bayani.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            double total = 0;
            String s;
            while((s = br.readLine()) != null) {
                double d = Double.parseDouble(s);
                out.printf("        $ %6.2f%n", d);
                total += d;
            }
            out.printf("Total = $ %6.2f%n", total);
        }
        br.close(); out.close();
    }
}
