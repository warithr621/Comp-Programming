// https://codeforces.com/contest/1320/problem/A

import java.util.*;
import java.io.*;

public class JourneyPlanning {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		HashMap<Integer, Long> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			int track = i - b;
			if (hm.containsKey(track)) {
				hm.put(track, hm.get(track) + b);
			} else hm.put(track, (long) b);
		}
		long mx = 0;
		for (int i : hm.keySet()) mx = Math.max(mx, hm.get(i));
		out.println(mx);

		out.close();
	}
}