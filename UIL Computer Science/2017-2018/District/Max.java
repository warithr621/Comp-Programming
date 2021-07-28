//Problem 10

import java.io.*;
import java.util.*;

public class Max {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("max.in"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    String[] num = {"Zero", "Wun", "Too", "Tree", "Fower", "Fife", "Six", "Seven", "Ait", "Niner"};
		    String[] pain = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India",
		    "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango",
		    "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu"};
		    while((s = br.readLine()) != null) {
		        for (int i = 0; i < s.length(); i++) {
		            char c = s.charAt(i);
		            if (c == '.') {
		                if (!num(s.charAt(i-1))) out.println("Stop ");
		                else out.print("Decimal ");
		            } else out.print((num(c) ? num[c - '0'] : pain[c - 'A']) + ' ');
		        }
		        out.println();
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
    static boolean num(char c) {
        return '0' <= c && c <= '9';
    }
}
