//Problem 1

import java.io.*;
import java.util.*;

public class Baldo {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("baldo.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            for (int i = 65; i <= 90; i++) out.printf("%c %d %c %d%n", (char) i, i, (char) (i+32), i+32);
        }
        br.close(); out.close();
    }
}