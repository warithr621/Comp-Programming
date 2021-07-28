//Problem 1

import java.io.*;
import java.util.*;

public class Andy {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("andy.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            out.println("   ooooo+\n  ooooo++\n ooooo+++\nooooo++++\nxxxxx++++\nxxxxx+++\nxxxxx++\nxxxxx+");
        }
        br.close(); out.close();
    }
}
