//Problem 2

import java.io.*;
import java.util.*;

public class Alok {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("alok.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            double ans = 0, track = 0;
            String s;
            while((s = br.readLine()) != null) {
                ans += Double.parseDouble(s);
                ++track;
            }
            out.printf("$%.2f%n$%.2f", ans, ans/track);
        }
        br.close(); out.close();
    }
}
