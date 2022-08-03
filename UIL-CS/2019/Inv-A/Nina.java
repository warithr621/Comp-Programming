import java.io.*;
import java.util.*;

public class Nina {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("nina.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    double radius = nextd();
		    double side = 2 * radius * Math.sin(Math.PI / 5.0);
		    double area = (5 * side * side) / (4 * Math.tan(Math.PI / 5.0));
		    out.printf("LOCATION #%d ", tt);
		    if (area > 43560) out.println("WILL NOT FIT");
		    else out.printf("%.2f %.2f%n", area, side * 5);
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
    static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
}