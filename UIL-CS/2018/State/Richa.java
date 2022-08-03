import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Richa {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("richa.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		int N = sc.nextInt();
		HashMap<Integer, Course> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			String str = sc.next();
			Course course = new Course(str);
			hm.put(num, course);
		}
		while(sc.hasNext()) {
			String g1 = sc.next();
			int c1 = sc.nextInt();
			String g2 = sc.next();
			int c2 = sc.nextInt();
			double pts = hm.get(c1).gpa(g1) + hm.get(c2).gpa(g2);
			int cr = hm.get(c1).credits + hm.get(c2).credits;
			out.printf("%.3f\n", pts / cr);
			// out.printf("%d %d\n", c1, c2);
			// out.printf("%.3f %.3f\n", hm.get(c1).gpa(g1), hm.get(c2).gpa(g2));
		}
	}
}

class Course {
	int credits;
	boolean honor;

	Course(String s) {
		char c = s.charAt(0), cc = s.charAt(1);
		honor = c == 'Y';
		if (cc == 'Y') credits = 4;
		else if (cc == 'S') credits = 2;
		else credits = 1;
	}
	double gpa(String grade) {
		double[] arr = new double[]{4.5, 3.5, 2.5, 1, 0, 0};
		double orig = arr[grade.charAt(0) - 'A'];
		if (grade.length() == 2) orig += grade.charAt(1) == '+' ? .25 : -.25;
		if (honor && grade.charAt(0) <= 'C') orig += 0.5;
		return orig * credits;
	}
}