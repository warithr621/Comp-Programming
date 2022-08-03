import java.io.*;
import java.util.*;

public class Bojing {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("bojing.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    HashSet<String> hs = new HashSet<String>();
		    String s;
		    while((s = br.readLine()) != null) {
		        st = new StringTokenizer(s);
		        while(st.hasMoreTokens()) hs.add(next());
		    }
		    ArrayList<Word> al = new ArrayList<Word>();
		    for (String str : hs) {
		        Word w = new Word(str);
		        al.add(w);
		    }
		    Collections.sort(al);
		    out.print(al.get(0) + " ");
		    for (int i = 1; i < al.size(); i++) {
		        if (al.get(i).length() != al.get(i-1).length()) out.println();
		        out.print(al.get(i) + " ");
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
class Word implements Comparable<Word> {
    String txt;
    public Word(String w) {
        this.txt = w;
    }
    public int length() {
        return txt.length();
    }
    public int compareTo(Word w) {
        if (this.txt.length() < w.txt.length()) return -1;
        if (this.txt.length() > w.txt.length()) return 1;
        return this.txt.compareTo(w.txt) < 0 ? -1 : 1;
    }
    public String toString() {
        return txt;
    }
}