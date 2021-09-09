//Problem 5

import java.io.*;
import java.util.*;

public class Emma {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("emma.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    st = new StringTokenizer(br.readLine());
		    while(st.hasMoreTokens()) {
		        int x = nexti();
		        char[][] c = new char[3*x][3*x];
		        for (int i = 0; i < 3*x; i++) Arrays.fill(c[i], ' ');
		        for (int i = 0; i < x; i++) for (int j = 0; j < x; j++) c[i][j] = c[i][3*x - j - 1] = '*';
		        for (int i = 3*x-1; i >= 2*x; i--) for (int j = 0; j < x; j++) c[i][j] = c[i][3*x - j - 1] = '*';
		        for (int i = 0; i < 3*x; i++) c[i][i] = c[i][3*x-i-1] = '*';
		        for (int i = 0; i < 3*x; i++) {
		            for (int j = 0; j < 3*x; j++) out.print(c[i][j]);
		            out.println();
		        }
		        out.println("==========");
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
