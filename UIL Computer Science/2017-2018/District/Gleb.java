//Problem 6

import java.io.*;
import java.util.*;

public class Gleb {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("gleb.in"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] notes = s.split(" ");
		        out.print(notes[0]);
		        shift(notes);
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
    static void shift(String[] notes) {
        String current = notes[0];
        ArrayList<String> n = new ArrayList<String>();
        n.add("A0"); n.add("B0");
        for (int i = 1; i <= 7; i++) {
            char[] c = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
            for (char ch : c) n.add(ch + Integer.toString(i));
        }
        n.add("C8");
        for (int i = 1; i < notes.length; i++) {
            int shift = Integer.parseInt(notes[i]);
            shift = shift > 0 ? --shift : ++shift;
            current = n.get(n.indexOf(current) + shift);
            out.print(' ' + current);
        }
    }
}
