//Problem 7

import java.io.*;
import java.util.*;

public class Luis {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("luis.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    double[] a = new double[10];
		    double[] cnt = new double[10];
		    String[] classes = {"Algebra", "Calculus", "Computer Science", "Economics", "English", "Geometry", "Government", "Spanish", "U.S. History", "World History"};
		    Arrays.fill(a, 0.0); Arrays.fill(cnt, 0.0);
		    HashMap<String, Double> hm = new HashMap<String, Double>();
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] temp = s.split(",");
		        String name = temp[0] + " " + temp[1];
		        double total = 0, c = 0;
		        for (int i = 2; i < 12; i++) {
		            if (temp[i].equals("NA")) continue;
		            int grade = Integer.parseInt(temp[i]);
		            a[i-2] += grade;
		            cnt[i-2]++;
		            total += grade;
		            c++;
		        }
		        hm.put(name, total / c);
		    }
		    for (String x : hm.keySet()) out.printf("%s %.3f%n", x, hm.get(x));
		    out.println("********************");
		    for (int i = 0; i < 10; i++) out.printf("%s %.3f%n", classes[i], a[i] / cnt[i]);
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
