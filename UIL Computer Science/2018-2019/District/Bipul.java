//Problem 1

import java.io.*;
import java.util.*;

public class Bipul {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("bipul.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            out.println("|");
            for (int i = 1; i <= 9; i += 2) {
                out.print("|");
                for (int j = 0; j < i; j++) out.print("#");
                out.println("\\");
            }
            for (int i = 2; i <= 9; i++) {
                out.print("|");
                for (int j = 0; j < i; j++) out.print("#");
                out.println("\\");
            }
        }
        br.close(); out.close();
    }
}
