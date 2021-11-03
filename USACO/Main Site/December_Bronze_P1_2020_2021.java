import java.io.*;
import java.util.*;

public class December_Bronze_P1_2020_2021 {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("__.in"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // out = new PrintWriter(new BufferedWriter(new FileWriter("__.out")));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int[] a = new int[7];
		    for (int i = 0; i < 7; i++) a[i] = nexti();
		    Arrays.sort(a);
		    out.printf("%d %d %d", a[0], a[1], a[6] - a[1] - a[0]);
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
