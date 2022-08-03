import java.io.*;
import java.util.*;

public class Joanna {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("joanna.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    double hourly_pay = nextd(), week_hour = nextd(), lap = nextd(), acc = nextd(), sales = nextd();
		    sales = 1 + sales / 100.0;
		    double net = round(round(hourly_pay * week_hour) * 0.9235) * 10;
		    double pur = round(sales * (lap + acc));
		    double rem = net - pur;
		    out.printf("Net Pay:  $%,8.2f%nPurchase: $%,8.2f%nFun Cash: $%,8.2f%n*********%n", net, pur, rem);
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