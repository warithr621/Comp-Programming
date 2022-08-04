// Samantha

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Samantha {
	static Scanner sc;

	static void solve() {
		String[] s = sc.nextLine().split(" ");
		double sub = 0;
		for (String str : s) {
			sub += Double.parseDouble(str);
		}
		out.printf("Subtotal: $%7.2f\nTax     : $%7.2f\nTotal   : $%7.2f\n=====\n", 
			sub, sub*0.0825, sub*1.0825);
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new File("samantha.dat"));
		while(sc.hasNextLine()) solve();
	}
}