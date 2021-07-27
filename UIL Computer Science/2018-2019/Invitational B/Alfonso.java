//Problem 1

import java.io.*;
import java.util.*;

public class Alfonso {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("alfonso.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            for (char x = 'A'; x < 'Z'; x += 4) {
                for (char y = x; y < 'Z'; y += 2) {
                    for (char z = y; z < 'Z'; z += 2) out.print(z);
                    out.println();
                }
            }
        }
        br.close(); out.close();
    }
}
