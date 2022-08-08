// Joe

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Joe {
	static Scanner sc;

	static void solve() {
    	String[] tmp = sc.nextLine().split("[\\s.,?!\"]");
    	for (int i = 0; i < tmp.length; i++) tmp[i] = tmp[i].toUpperCase();
    	Arrays.sort(tmp, new Comparator<String>(){
    	    public int compare(String a, String b) {
    	        if (a.length() != b.length()) return a.length() - b.length();
    	        else return a.compareTo(b);
    	    }
    	});
    	HashSet<String> ans = new HashSet<>();
    	for (String s : tmp) if (s.length() != 0) {
    	    if (!ans.contains(s)) out.print(s + " ");
    	    ans.add(s);
    	}
    	out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("joe.dat"));
		while(sc.hasNextLine()) solve();
	}
}