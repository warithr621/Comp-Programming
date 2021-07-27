//Problem 10

import java.io.*;
import java.util.*;

public class Raghav {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("raghav.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        T = 50;
        for (int tt = 1; tt <= T; tt++) {
            int x = Integer.parseInt(br.readLine());
            if (tt % 2 == 0) x *= 2;
            else x += 7;
            if (tt % 3 == 0) x *= 5;
            if (tt % 5 == 0) x -= 11;
            if (tt % 7 == 0) x *= x;
            if (tt % 10 == 0) x /= 10;
            if (tt % 11 == 0) x = (int) Math.sqrt(x);
            out.println(x);
        }
        br.close(); out.close();
    }
}
