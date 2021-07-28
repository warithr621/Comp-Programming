//Problem 2

import java.io.*;
import java.util.*;

public class Banu {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("banu.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String[] a = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String s;
            while((s = br.readLine()) != null) out.println(a[Integer.parseInt(s)]);
        }
        br.close(); out.close();
    }
}
