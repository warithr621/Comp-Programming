//Problem 7

import java.io.*;
import java.util.*;

public class Judith {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("judith.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            TreeMap<Double, String> tm = new TreeMap<Double, String>();
            while((s = br.readLine()) != null) {
                tm.put(Double.parseDouble(s), s);
            }
            for (Double d : tm.keySet()) out.println(tm.get(d));
        }
        br.close(); out.close();
    }
}