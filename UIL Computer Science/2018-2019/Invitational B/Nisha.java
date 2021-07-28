//Problem 10

import java.io.*;
import java.util.*;

public class Nisha {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("nisha.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            long x = Long.parseLong(br.readLine());
            out.printf("Case #%d: %d%n", tt, (int) (x * Math.pow(2, x-1) + 1));
        }
        br.close(); out.close();
    }
}
