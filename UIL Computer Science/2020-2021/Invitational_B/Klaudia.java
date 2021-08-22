//Problem 7

import java.io.*;
import java.util.*;

public class Klaudia {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("klaudia.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s = br.readLine();
		    String letter = "";
		    for (int i = 0; i < s.length(); i++) {
		        char C = s.charAt(i);
		        if (C == ' ') {
		            out.print(morse(letter));
		            
		            if (s.charAt(i+1) == '/') {
		                out.print(" ");
		                i += 2;
		            }
		            letter = "";
		        } else letter += C;
		    }
		    out.println(morse(letter));
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
    static char morse(String s) {
        String[] L = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] N = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};
        for (int i = 0; i < 26; i++) if (L[i].equals(s)) return (char) (i + 65);
        for (int i = 0; i < 10; i++) if (N[i].equals(s)) return (char) (i + 48);
        return '+';
    }
}
