//Problem 5

import java.io.*;
import java.util.*;

public class Egor {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("egor.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            int x = Integer.parseInt(br.readLine());
            TreeSet<String> ts = new TreeSet<String>();
            while(x-->0) {
                String s = br.readLine();
                if (s.length() < 5 || s.length() > 8) continue;
                if (s.equals("Egor")) continue;
                if (s.charAt(0) > 'M') continue;
                boolean f = true;
                for (int i = 0; i < s.length()-1; i++) {
                    if (s.charAt(i) == 'p' && s.charAt(i+1) == 'h') f = false;
                    char c = s.charAt(i), a = s.charAt(i+1);
                    if (cmoy(c) || cmoy(a)) f = false;
                }
                if (f) ts.add(s);
            }
            for (String s : ts) out.println(s);
        }
        br.close(); out.close();
    }
    static boolean cmoy(char c) {
        if (c < 'a') c = (char) (c + 32);
        return c == 'c' || c == 'm' || c == 'o' || c == 'y';
    }
}
