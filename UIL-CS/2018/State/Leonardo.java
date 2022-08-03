import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Leonardo {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("leonardo.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		while(sc.hasNextLine()) {
			String[] arr = sc.nextLine().split(" = ");
			for (String s : arr[0].split(" ")) {
				out.print(s.charAt(0));
			}
			out.print(" = ");
			for (String s : arr[1].split(" ")) {
				out.print((char) (s.charAt(s.length()-1) - 32));
			}
			out.println();
		}
	}
}