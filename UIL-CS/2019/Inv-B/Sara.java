// Sara

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Sara {
	static Scanner sc;

	static void solve() {
		String[] bride = sc.nextLine().split(" ");
		String[] groom = sc.nextLine().split(" ");
		Arrays.sort(bride); Arrays.sort(groom);
		TreeSet<String> ovr = new TreeSet<>();
		TreeSet<String> both = new TreeSet<>();
		for (String s : bride) {
			if (ovr.contains(s)) both.add(s);
			else ovr.add(s);
		}
		for (String s : groom) {
			if (ovr.contains(s)) both.add(s);
			else ovr.add(s);
		}
		int r = 0, b = 0, g = 0;
	    
		out.print("Guests: ");
		for (String s : ovr) out.print(s + " ");
		out.println();
	    
		out.print("Guests of Both: ");
		for (String s : both) {out.print(s + " "); ++r;}
		if (r == 0) out.print("none");
		out.println();
	    
		out.print("Bride's Guests: ");
		for (String s : bride) if (!both.contains(s)) {
			out.print(s + " "); ++b;
		}
		if (b == 0) out.print("none");
		out.println();
	    
		out.print("Groom's Guests: ");
		for (String s : groom) if (!both.contains(s)) {
			out.print(s + " "); ++g;
		}
		if (g == 0) out.print("none");
		out.println();
	    
		out.println("--------------------");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("sara.dat"));
		int T = Integer.parseInt(sc.nextLine());
		while(T-->0) solve();
	}
} 
