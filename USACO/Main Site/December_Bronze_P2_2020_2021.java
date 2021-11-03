import java.io.*;
import java.util.*;

public class December_Bronze_P2_2020_2021 {
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
		    int n = nexti();
		    int[] a = new int[n];
		    for (int i = 0; i < n; i++) a[i] = nexti();
		    int ans = n;
		    for (int i = 2; i <= n; i++) {
		        for (int j = 0; j <= n - i; j++) {
		            int sum = 0;
		            for (int k = j; k < j + i; k++) sum += a[k];
		            boolean b = false;
		            for (int k = j; k < j+i; k++) b |= a[k] * i == sum;
		            ans += b ? 1 : 0;
		        }
		    }
		    out.println(ans);
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