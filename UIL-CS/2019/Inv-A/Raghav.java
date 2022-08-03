import java.io.*;
import java.util.*;

public class Raghav {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("raghav.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int[] a = new int[51];
		    for (int i = 1; i <= 50; i++) a[i] = nexti();
		    for (int i = 1; i <= 50; i++) {
		        if (i % 2 == 1) a[i] += 7;
		        else a[i] *= 2;
		        if (i % 3 == 0) a[i] *= 5;
		        if (i % 5 == 0) a[i] -= 11;
		        if (i % 7 == 0) a[i] *= a[i];
		        if (i % 10 == 0) a[i] /= 10;
		        if (i % 11 == 0) a[i] = (int) Math.floor(Math.sqrt(a[i]));
		    }
		    for (int i = 1; i <= 50; i++) out.println(a[i]);
		    
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