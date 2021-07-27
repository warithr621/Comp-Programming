//Problem 7

import java.io.*;
import java.util.*;

public class Hyun {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("hyun.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int[] row = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
            boolean[] exists = {false, false, false, false};
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('0' <= c && c <= '9') exists[0] = true;
                if ('a' <= c && c <= 'z') exists[row[c - 'a']] = true;
            }
            out.printf("Case #%d: %s%s%s%s%n", tt, exists[0] ? "NUMBER " : "", exists[1] ? "TOP " : "", exists[2] ? "HOME " : "", exists[3] ? "BOTTOM " : "");
        }
        br.close(); out.close();
    }
}
