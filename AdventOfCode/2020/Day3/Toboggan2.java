// AoC 2020 D3

import java.util.*;
import java.io.*;

public class Toboggan2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<String> al = new ArrayList<>();
		while(sc.hasNext()) al.add(sc.next());
		int n = al.size(), i = 0, j = 0;
		long ans = 1; //apparently the answer is very fat

		for (int sh = 1; sh < 8; sh += 2) {
			i = 0; j = 0; int cnt = 0;
			while(i != n) {
				if (al.get(i).charAt(j) == '#') ++cnt;

				++i;
				j = (j + sh) % al.get(0).length();
			}
			ans *= cnt;
		}

		i = 0; j = 0; int cnt = 0;
		while(i < n) {
			if (al.get(i).charAt(j) == '#') ++cnt;

			i += 2; j = (j + 1) % al.get(0).length();
		}

		System.out.println(ans*cnt);
	}
}