//Problem 1

import java.io.*;
import static java.lang.System.*;
import java.util.*;

public class Alice {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("alice.dat"));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            for (int i = 1; i <= 3; i++) {
                space();
                for (int j = 0; j < i; j++) out.print("&");
                out.println();
            }
            for (int i = 1; i <= 4; i++) {
                space();
                out.print("&&");
                for (int j = 0; j < i; j++) out.print("-");
                out.println("&");
            }
            for (int i = 1; i <= 13; i++) {
                space();
                out.print("&&--");
                for(int j = 0; j < i; j++) out.print(".");
                out.println("--&");
            }
            space();
            out.println(" ||                   \\o/");
            space();
            out.println(" ||                    |");
            out.println(" ======================================");
            out.println("   ==================================");
            out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        br.close(); out.close();
    }
    static void space() {
        out.print("           ");
    }
}
