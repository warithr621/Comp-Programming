//Problem 6

import java.io.*;
import java.util.*;

public class Gowri {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("gowri.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int x = Integer.parseInt(br.readLine());
            out.print("    ");
            for (int i = 0; i < x; i++) out.print('*');
            out.println("    ");
            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < i; j++) out.print(' ');
                out.print('*');
                for (int j = 0; j < x + 2*(-i+3); j++) out.print(' ');
                out.println("*");
            }
            for(int i = 0; i < x; i++) {
                out.print('*');
                for (int j = 0; j < x+6; j++) out.print(' ');
                out.println('*');
            }
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < i; j++) out.print(' ');
                out.print('*');
                for (int j = 0; j < x + 2*(-i+3); j++) out.print(' ');
                out.println("*");
            }
            out.print("    ");
            for (int i = 0; i < x; i++) out.print('*');
            out.println("    ");
            out.println("--------------------");
        }
        br.close(); out.close();
    }
}
