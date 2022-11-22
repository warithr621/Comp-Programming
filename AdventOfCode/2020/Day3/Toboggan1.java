// AoC 2020 D3

import java.util.*;
import java.io.*;

public class Toboggan1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<String> al = new ArrayList<>();
		while(sc.hasNext()) al.add(sc.next());
		int n = al.size(), ans = 0, i = 0, j = 0;

		while(i != n) {
			if (al.get(i).charAt(j) == '#') ++ans;

			++i;
			j = (j + 3) % al.get(0).length();
		}

		System.out.println(ans);
	}
}