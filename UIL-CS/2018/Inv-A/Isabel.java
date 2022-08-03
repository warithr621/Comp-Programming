//Problem 4

import java.io.*;
import java.util.*;

public class Isabel {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("isabel.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    ArrayList<Bday> al = new ArrayList<Bday>();
		    while((s = br.readLine()) != null) {
		        String[] a = s.split(" ");
		        int y = Integer.parseInt(a[1]), m = Integer.parseInt(a[2]), d = Integer.parseInt(a[3]);
		        Calendar c = Calendar.getInstance();
		        c.set(y, m-1, d);
		        int dow = c.get(Calendar.DAY_OF_WEEK);
		        Bday b = new Bday(d, m, y, dow, a[0]);
		        al.add(b);
		    }
		    Collections.sort(al);
		    for (Bday b : al) out.println(b);
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
class Bday implements Comparable<Bday> {
    int day, month, year, day_of_week;
    String name;
    String[] D = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String[] M = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    Bday(int d, int m, int y, int dow, String s) {
        this.day = d;
        this.month = m;
        this.year = y;
        this.day_of_week = dow;
        this.name = s;
    }
    public int compareTo(Bday b) {
        if (this.day_of_week < b.day_of_week) return -1;
        if (this.day_of_week > b.day_of_week) return 1;
        if (this.name.compareTo(b.name) < 0) return -1;
        else return 1;
    }
    public String toString() {
        String temp = name;
        while(temp.length() < 11) temp += ' ';
        return temp + ": " + D[day_of_week - 1] + ", " + M[month-1] + " " + day + ", " + year;
    }
}