// 2019 Dec Silver P1

import java.util.*;
import java.io.*;

public class Moobuzz {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // mfw file I/O
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        //bruh this took way too long to impl
        long n = Long.parseLong(br.readLine());
        --n;
        //1 2 M 4 M M 7 8 M M 11 M 13 14 M ...
        long ans = n / 8 * 15;
        n %= 8;
        int[] a = {1, 2, 4, 7, 8, 11, 13, 14};
        out.println(ans + a[(int)n]);
        
        br.close(); out.close();
    }
}