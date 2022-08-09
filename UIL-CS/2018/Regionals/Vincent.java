// Vincent

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Vincent {
	static Scanner sc;

	static void format(Calendar c) {
		String[] month = new String[]{"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"};
	    
	}

	static void solve() {
		Calendar cal = Calendar.getInstance();
		cal.set(sc.nextInt(), sc.nextInt()-1, sc.nextInt(), sc.nextInt(), sc.nextInt(), 0);
		sc.nextLine();
		out.printf("%tB %td, %tY - %tI:%tM %Tp\n",cal,cal,cal,cal,cal,cal);
		out.println("-----");
		long mil = cal.getTimeInMillis();
		String[] s = sc.nextLine().split(" ");
		for (String str : s) {
			long m = Long.parseLong(str);
			cal.setTimeInMillis(mil + m*60000);
			out.printf("%tB %td, %tY - %tI:%tM %Tp\n",cal,cal,cal,cal,cal,cal);
		}
		out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("vincent.dat"));
		while(sc.hasNext()) solve();
	}
}
