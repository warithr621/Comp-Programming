// AoC 2022 D1

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class CalorieCounting2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<Integer> a = new ArrayList<>();
		int x = 0;

		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			try {
				x += Integer.parseInt(s);
			} catch (Exception e) {
				a.add(x);
				x = 0;
			}
		}

		Collections.sort(a, Collections.reverseOrder());
		out.print(a.get(0) + a.get(1) + a.get(2));
	}
}