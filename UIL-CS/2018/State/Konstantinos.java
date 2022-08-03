import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Konstantinos {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("konstantinos.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		while(sc.hasNext()) {
			int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt();
			int x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();
			double d = dist(x1, y1, x2, y2);
			if (d > r1 + r2) {
				out.println("NON-INTERSECTING");
				continue;
			}
			if (d == r1 + r2) {
				out.println("EXTERNALLY TANGENT");
				continue;
			}
			//still have to do: intersecting, nested, intertan
			if (r1 > d + r2 || r2 > d + r1) {
				out.println("NESTED");
				continue;
			}
			if (Math.abs(r1 - r2) == d) {
				out.println("INTERNALLY TANGENT");
			} else out.println("INTERSECTING");
		}
	}

	static double dist(int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x1-x2);
		int dy = Math.abs(y1-y2);
		return Math.sqrt(dx*dx + dy*dy);
	}
}