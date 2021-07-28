//Problem 4

import java.io.*;
import java.util.*;

public class Carla {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("carla.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s;
            String[] ret = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx"};
            while((s = br.readLine()) != null) {
                out.printf("%c%s%s%s%n", s.charAt(0) == 'D' ? 'd' : (s.charAt(0) == 'F' ? '-' : 'l'), ret[s.charAt(1) - '0'], ret[s.charAt(2) - '0'], ret[s.charAt(3) - '0']);
            }
        }
        br.close(); out.close();
    }
}
