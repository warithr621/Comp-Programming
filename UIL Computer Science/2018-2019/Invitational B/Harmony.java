//Problem 6

import java.io.*;
import java.util.*;

public class Harmony {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("harmony.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s = br.readLine();
            int len = s.length();
            int fin = s.charAt(len-1) - '0';
            out.print(s + " ");
            int os = 0, es = 0, geq = 0;
            for (int i = 0; i < len-1; i++) {
                if (i % 2 == 0) os += s.charAt(i) - '0';
                else es += s.charAt(i) - '0';
                if (i % 2 == 0 && s.charAt(i) > '4') ++geq;
            }
            int chk_sum = 3*os + es + geq;
            int chk_dig = 10 - chk_sum % 10;
            out.println(chk_dig == fin ? "VALID" : "INVALID " + chk_dig);
        }
        br.close(); out.close();
    }
}
