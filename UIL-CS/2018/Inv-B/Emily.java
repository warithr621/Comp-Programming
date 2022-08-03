//Problem 5

import java.io.*;
import java.util.*;

public class Emily {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("emily.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            while((s = br.readLine()) != null) {
                String[] lol = s.split(" ");
                int a = Integer.parseInt(lol[0]), b = Integer.parseInt(lol[1]), h = Integer.parseInt(lol[2]);
                double ans = (a + b) / 2.0 * h;
                if (a % 2 == b % 2 || h % 2 == 0) out.println((int) ans);
                else out.println(ans);
            }
        }
        br.close(); out.close();
    }
}