//Problem 9

import java.io.*;
import java.util.*;

public class Nina {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("nina.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            double r = Double.parseDouble(br.readLine());
            double pi = Math.PI;
            double side = 2 * r * Math.sin(pi / 5);
            double area = (5 * side * side) / (4 * Math.tan(pi/5));
            out.printf("LOCATION #%d ", ttt);
            if (area > 43560) out.println("WILL NOT FIT");
            else out.printf("%.2f %.2f%n", area, 5 * side);
        }
        br.close(); out.close();
    }
}
