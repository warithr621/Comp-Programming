//Problem 1

import java.io.*;
import java.util.*;

public class Aaron {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("aaron.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // 	T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            char[] c = {'[', '\\', ']', '^', '_', '`'};
            for (int i = 21; i >= 16; i--) {
                for (int j = 0; j < i; j++) out.print(c[i-16]);
                out.println();
            }
        }
        br.close(); out.close();
    }
}