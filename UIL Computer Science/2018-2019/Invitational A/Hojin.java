//Problem 5

import java.io.*;
import java.util.*;

public class Hojin {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("hojin.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
            out.printf("Case #%d: %d%n", ttt, gcd(a, b));
        }
        br.close(); out.close();
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
