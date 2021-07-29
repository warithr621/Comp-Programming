//Problem 11

import java.io.*;
import java.util.*;

public class Nandita {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("nandita.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] a = s.split(" ");
		        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		        int temp = Arrays.asList(months).indexOf(a[0]);
		        String M = (temp < 10 ? "0" : "") + Integer.toString(++temp);
		        String[] bruh = a[1].split(",");
		        temp = Integer.parseInt(bruh[0]);
		        String D = (temp < 10 ? "0" : "") +Integer.toString(temp);
		        String Y = a[2];
		        out.printf("%s/%s/%s%n%s.%s.%s%n%s-%s-%s%n=====%n", M, D, Y, D, M, Y, Y, M, D);
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
}
