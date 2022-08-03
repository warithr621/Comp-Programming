//Problem 3

import java.io.*;
import java.util.*;

public class Constanza {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("constanza.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
            int[] freq = {0, 0, 0, 0, 0, 0, 0};
            while((s = br.readLine()) != null) freq[find(colors, s)]++;
            for (int i = 0; i < 7; i++) {
                out.printf("%-7s ", colors[i]);
                for (int j = 0; j < freq[i]; j++) out.print('*');
                out.println();
            }
        }
        br.close(); out.close();
    }
    public static int find(String[] s, String t) {
        for (int i = 0; i < 7; i++) if (s[i].equals(t)) return i;
        return -1;
    }
    
}