//Problem 2

import java.io.*;
import java.util.*;

public class Chaoxiang {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("chaoxiang.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // 	T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            while((s = br.readLine()) != null) {
                double x = Double.parseDouble(s);
                out.printf("%.2f%n", (x - 32) / 1.8 + 273.16);
            }
        }
        br.close(); out.close();
    }
}