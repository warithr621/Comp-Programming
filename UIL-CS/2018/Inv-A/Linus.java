//Problem 6

import java.io.*;
import java.util.*;

public class Linus {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("linus.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            int g = gcd(n, d);
            n /= g; d /= g;
            if (n == 0) {
                out.println(0);
                continue;
            }
            if (n >= d) {
                out.print(n/d + " ");
                n -= n/d*d;
            }
            if (n != 0) out.printf("%d/%d", n, d);
            out.println();
        }
        br.close(); out.close();
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}