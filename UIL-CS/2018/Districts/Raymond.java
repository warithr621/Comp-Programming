// Raymond

import java.util.*;
import java.io.*;

public class Raymond {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("raymond.dat"));
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.printf("%d %d\n", n, ~n);
		}
	}
}