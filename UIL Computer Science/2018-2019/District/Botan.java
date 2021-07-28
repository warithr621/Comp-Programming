//Problem 3

import java.io.*;
import java.util.*;

public class Botan {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("botan.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            boolean[] b = {false, false, true, true, false, true, false, true, false, false};
            String s = br.readLine();
            boolean f = true;
            for (int i = 0; i < s.length(); i++) if(b[s.charAt(i) - '0'] == false) f = false;
            out.printf("Case #%d: %s%n", tt, f ? "BOTAN-PRIME" : "NOT BOTAN-PRIME");
        }
        br.close(); out.close();
    }
}
