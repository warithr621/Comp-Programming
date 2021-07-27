//Problem 1

import java.io.*;
import java.util.*;

public class Aaditya {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("aaditya.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            out.println("Programming in Java is Awesome!!\nJava PROGRAMMERS rock the world!");
        }
        br.close(); out.close();
    }
}
