import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Johnny {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("johnny.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		HashMap<String, Character> hm = new HashMap<>();
		while(sc.hasNextLine()) {
			String[] a = sc.nextLine().split(" ");
			char c = a[0].charAt(0);
			if ('A' <= c && c <= 'Z') {
				//sentence
				for (String s : a) out.print(hm.get(s));
				out.println();
			} else {
				//seq
				for (String s : a[1].split("/")) {
					hm.put(s, c);
				}
			}
		}
	}
}