import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Romero {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("romero.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		int n = sc.nextInt();
		out.println("Date               Attendance Gross      ATP   STP   Adults Stu/Child|");
		while(n-->0) {
			String s = sc.next();
			out.printf("%-18s ", date(s));
			int attendance = sc.nextInt();
			double gross = sc.nextDouble();
			double atp = sc.nextDouble(), stp = sc.nextDouble();
			out.printf("%-10d ", attendance);
			out.printf("$%-,9.2f ", gross);
			out.printf("$%-4.2f $%-4.2f ", atp, stp);

			double student = (gross - atp * attendance) / (stp - atp);
			double adult = attendance - student;

			out.printf("%-6d %-9d|", (int) adult, (int) student);
			out.println();
		}
	}
	static String date(String s) {
		String[] arr = s.split("/");
		String[] months = new String[]{"", "", "", "", "", "", "", ""
		, "", "September", "October", "November", "December"};
		String ans = months[Integer.parseInt(arr[0])] + " " + 
		arr[1] + ", " + arr[2];
		return ans;
	}
}