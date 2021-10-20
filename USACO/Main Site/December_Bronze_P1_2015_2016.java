import java.io.*;
import java.util.*;

public class December_Bronze_P1_2015_2016 {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("paint.in"));
// 		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int a = nexti(), b = nexti(), c = nexti(), d = nexti();
		    if (a > c) {
		        int temp = a;
		        a = c;
		        c = temp;
		        temp = b;
		        b = d;
		        d = temp;
		    }
		    if (b > c) out.println(b > d ? b-a : d-a);
		    else out.println(b + d - c - a);
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
}
