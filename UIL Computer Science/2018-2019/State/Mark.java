//Problem 8

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Mark {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("mark.dat"));
		int cur = 0;
		while(sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			for (int i = 0; i < s.length; i += 2) {
				int letter = 0;
				double x = Double.parseDouble(s[i]), y = Double.parseDouble(s[i+1]);
				x /= 22.5; y /= 22.5;
				cur = (int) (cur + x + 80) % 16;
				letter += 16 * cur;
				cur = (int) (cur + y + 80) % 16;
				letter += cur;
				out.print((char) letter);
				if (letter == '.' || letter == '!' || letter == '?') out.println();
			}
		}
	}
}