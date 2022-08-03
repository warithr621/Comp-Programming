import java.io.*;
import java.util.*;

public class Vlad {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("vlad.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    ArrayList<Name> al = new ArrayList<Name>();
		    while((s = br.readLine()) != null) {
		        st = new StringTokenizer(s);
		        next();
		        String L = next(), F = next(), M = "-";
		        if (st.hasMoreTokens()) M = next().substring(0,1);
		        L = L.substring(0, L.length() - 1);
		        Name n = new Name(F, M, L);
		        al.add(n);
		    }
		    Collections.sort(al);
		    for (Name n : al) out.println(n);
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
class Name implements Comparable<Name> {
    String first, middle, last;
    public Name(String f, String m, String l) {
        this.first = f;
        this.middle = m;
        this.last = l;
    }
    public int compareTo(Name n) {
        if (this.last.compareTo(n.last) < 0) return -1;
        if (this.last.compareTo(n.last) > 0) return 1;
        if (this.first.compareTo(n.first) < 0) return -1;
        if (this.first.compareTo(n.first) > 0) return 1;
        return this.middle.compareTo(n.middle) < 0 ? -1 : 1;
    }
    public String toString() {
        return first + " " + (middle.equals("-") ? "" : middle + " ") + last;
    }
}