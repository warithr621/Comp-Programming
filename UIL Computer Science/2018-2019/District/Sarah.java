//Problem 11

import java.io.*;
import java.util.*;

public class Sarah {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("sarah.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s;
            while((s = br.readLine()) != null) {
                String[] temp = s.split(" ");
                for(String str : temp) {
                    out.print(str + " ");
                    char[] c = str.toCharArray();
                    if (vow(c[0])) swap(c, 0, 1);
                    for (int i = 1; i < c.length-1; i++) if(vow(c[i])) swap(c, i-1, i+1);
                    if (vow(c[c.length-1])) swap(c, 0, c.length-1);
                    for (char ch : c) out.print(ch);
                    out.println();
                }
            }
        }
        br.close(); out.close();
    }
    static boolean vow(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    static void swap(char[] c, int L, int R) {
        char temp = c[L];
        c[L] = c[R];
        c[R] = temp;
    }
}
