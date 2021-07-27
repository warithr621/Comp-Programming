//Problem 4

import java.io.*;
import java.util.*;

public class Eduardo {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("eduardo.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s;
            while((s = br.readLine()) != null) {
                String[] message = s.split(" ");
                int cipher = message[0].length();
                for (String str : message) {
                    for (int i = 0; i < str.length(); i++) out.print(caesar(str.charAt(i), cipher));
                    out.print(' ');
                }
                out.println();
            }
        }
        br.close(); out.close();
    }
    public static char caesar(char c, int x) {
        int orig = c - 'a';
        orig = (orig + x) % 26;
        return (char) (orig + 'a');
    }
}
