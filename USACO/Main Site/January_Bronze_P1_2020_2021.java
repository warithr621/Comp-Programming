import java.io.*;
import java.util.*;

public class January_Bronze_P1_2020_2021 {
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
		    String alpha = next(), s = next();
		    int ans = 0;
		    int cur = 0;
		    for (int i = 0; i < 26; i++) if (alpha.charAt(i) == s.charAt(0)) cur = i;
		    for (int i = 1; i < s.length(); i++) {
		        int temp = 0;
		        for (int j = 0; j < 26; j++) if (alpha.charAt(j) == s.charAt(i)) temp = j;
		        ans += temp > cur ? 0 : 1;
		        cur = temp;
		    }
		    out.println(++ans);
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
