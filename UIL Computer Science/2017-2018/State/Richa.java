//Problem 11

import java.io.*;
import java.util.*;
 
public class Richa {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("richa.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti();
		    TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		    for (int i = 0; i < n; i++) {
		        tm.put(nexti(), next());
		    }
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" ");
		        int gp = 0; double total = 0;
		        for (int i = 0; i < 2; i++) {
		            String letter = t[2*i];
		            int course = Integer.parseInt(t[2*i+1]);
		            double x = 0, g = 0;
		            String temp = tm.get(course);
		            boolean honor = temp.charAt(0) == 'Y' ? true : false;
		            double[] score = {4.5, 3.5, 2.5, 1.0, 69420.1337, 0.0};
		            x += score[letter.charAt(0) - 'A'];
		            if (letter.length() > 1) x += letter.charAt(1) == '+' ? 0.25 : -0.25;
		            if (honor && letter.charAt(0) < 'D') x += 0.5;
		            if (temp.charAt(1) == 'Y') g += 4;
		            else g += temp.charAt(1) == 'S' ? 2 : 1;
		            total += x * g;
		            gp += g;
		        }
		        out.printf("%.3f%n", total/gp);
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
