//Problem 3

import java.io.*;
import java.util.*;

public class Deshi {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("deshi.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // 	T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            while((s = br.readLine()) != null) {
                int vowel = 0, consonant = 0;
                boolean v = vow(s.charAt(0)) ? true : false;
                int track = 1;
                for (int i = 1; i < s.length(); i++) {
                    if (v) {
                        if (vow(s.charAt(i))) ++track;
                        else {
                            v = !v;
                            vowel = Math.max(vowel, track);
                            track = 1;
                        }
                    } else {
                        if (!vow(s.charAt(i))) ++track;
                        else {
                            v = !v;
                            consonant = Math.max(consonant, track);
                            track = 1;
                        }
                    }
                }
                out.printf("%s %s%n", vowel > 4 || consonant > 7 ? "NOT ACCEPTABLE" : "ACCEPTABLE", s);
            }
        }
        br.close(); out.close();
    }
    public static boolean vow(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}