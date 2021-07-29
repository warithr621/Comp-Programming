//Problem 12

import java.io.*;
import java.util.*;
 
public class Romero {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("romero.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		out.println("Date                Attendance Gross      ATP   STP   Adults Stu/Child|");
		for (int tt = 1; tt <= T; tt++) {
		    String date = date(next());
		    int att = nexti();
		    double gross = nextd();
		    double atp = nextd();
		    double stp = nextd();
		    int[] ads = eq(att, gross, atp, stp);
		    out.printf("%-19s %-10d $%,9.2f $%4.2f $%4.2f %-6d %-9d%n", date, att, gross, atp, stp, ads[0], ads[1]);
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
    static String date(String s) {
        String[] t = s.split("/");
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[Integer.parseInt(t[0]) - 1] + " " + t[1] + ", " + t[2];
    }
    static int[] eq(int att, double gross, double atp, double stp) {
        int x = (int) ((gross - stp * att) / (atp - stp));
        int y = att - x;
        int[] ret = {x, y};
        return ret;
    }
}
