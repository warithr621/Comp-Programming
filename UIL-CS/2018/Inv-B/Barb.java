   
//Problem 2

import java.io.*;
import java.util.*;

public class Barb {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("barb.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            while((s = br.readLine()) != null) {
                out.print(s + " ");
                for (int i = s.length()-1; i >= 0; i--) out.print((char) (s.charAt(i)-32));
                out.print(' ');
                for (int i = (s.length()-1)/2; i >= 0; i--) out.print(s.charAt(i));
                out.print(' ');
                for (int i = s.length()/2; i < s.length(); i++) out.print((char) (s.charAt(i) - 32));
                out.println();
            }
        }
        br.close(); out.close();
    }
}