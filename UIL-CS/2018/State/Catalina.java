import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Catalina {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("catalina.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); i++) {
				if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
					out.print(s.charAt(i));
				}
			}
			out.println();
		}
	}
}