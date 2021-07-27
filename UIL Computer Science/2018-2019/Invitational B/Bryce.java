//Problem 3

import java.io.*;
import java.util.*;

public class Bryce {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("bryce.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s;
            while((s = br.readLine()) != null) {
                int x = Integer.parseInt(s);
                out.print(x + ":");
                while(x >= 1000) {
                    x -= 1000;
                    out.print("M");
                }
                String[] temp = {"", "C", "CC", "CCC", "CCCC", "D", "DC", "DCC", "DCCC", "CM"};
                out.print(temp[(x - x % 100) / 100]);
                x %= 100;
                temp = new String[]{"", "X", "XX", "XXX", "XXXX", "L", "LX", "LXX", "LXXX", "XC"};
                out.print(temp[(x - x%10) / 10]);
                x %= 10;
                temp = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
                out.println(temp[x]);
            }
        }
        br.close(); out.close();
    }
}
