//Problem 12

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
		    ArrayList<Student> al = new ArrayList<Student>();
		    while((s = br.readLine()) != null) {
		        st = new StringTokenizer(s);
		        nexti();
		        String L = next(), F = next(), M = "";
		        if (st.hasMoreTokens()) M = next();
		        L = L.substring(0, L.length()-1);
		        if (!M.equals("")) M = M.substring(0,1);
		        Student thonk = new Student(F, M, L);
		        al.add(thonk);
		    }
		    Collections.sort(al);
		    for (Student thinkies : al) out.println(thinkies);
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

class Student implements Comparable<Student> {
    String f, m, l;
    Student(String first, String middle, String last) {
        this.f = first;
        this.m = middle.equals("") ? "-----" : middle;
        this.l = last;
    }
    public String toString() {
        return f + " " + (m.equals("-----") ? "" : m + " ") + l;
    }
    public int compareTo(Student s) {
        if (this.l.compareTo(s.l) < 0) return -1;
        if (this.l.compareTo(s.l) > 0) return 1;
        if (this.f.compareTo(s.f) < 0) return -1;
        if (this.f.compareTo(s.f) > 0) return 1;
        return this.m.compareTo(s.m) < 0 ? -1 : 1;
    }
    
}
