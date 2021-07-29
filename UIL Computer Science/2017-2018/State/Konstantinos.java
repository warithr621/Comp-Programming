//Problem 7

import java.io.*;
import java.util.*;
 
public class Konstantinos {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("konstantinos.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" ");
		        double x1 = Integer.parseInt(t[0]), y1 = Integer.parseInt(t[1]), r1 = Integer.parseInt(t[2]);
		        double x2 = Integer.parseInt(t[3]), y2 = Integer.parseInt(t[4]), r2 = Integer.parseInt(t[5]);
		        double dist = distance(x1, x2, y1, y2);
		        if (dist > r1 + r2) out.println("NON-INTERSECTING");
		        else if (dist == r1 + r2) out.println("EXTERNALLY TANGENT");
		        else {
		            if (dist < Math.max(r1, r2)) {
		                out.println(dist == r1 + r2 || dist == r1 - r2 ? "INTERNALLY TANGENT" : "NESTED");
		            } else out.println("INTERSECTING");
		        }
		    }
		}
		br.close(); out.close();
	}
	static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nexti() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextl() throws IOException {
        return Long.parseLong(next());
    }
    static double nextd() throws IOException {
        return Double.parseDouble(next());
    }
    static double distance(double x1, double y1, double x2, double y2) {
        double horiz = (x2 - x1) * (x2 - x1);
        double vert = (y2 - y1) * (y2 - y1);
        return Math.sqrt(horiz + vert);
    }
}
