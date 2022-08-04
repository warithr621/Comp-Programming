// Nikita

import java.util.*;
import java.io.*;

public class Nikita {
	static Scanner sc;

	static void solve() {
		int n = sc.nextInt();
		int[][] adj = new int[n][n]; //input adj matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) adj[i][j] = sc.nextInt();
		}


		MultiSet[] ms = new MultiSet[n]; //essentially, frequency
		for (int i = 0; i < n; i++) ms[i] = new MultiSet();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) ms[i].add(adj[i][j]);
			//stores frequencies
		}

		HashMap<Character, Integer> degree = new HashMap<>(), close = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = (char) ('A' + i);
			int deg = ms[i].get(1); //degree = # of 1's
			if (deg != -1) degree.put(c, deg);

			int sum = 0;
			for (int j = 0; j < n; j++) {
				int cur = ms[i].get(j); //closeness = 1 * #1s + 2*#2s + ...
				if (cur != -1) sum += cur * j;
			}
			close.put(c, sum);

// 			System.out.println(c + " " + deg + " " + sum); yum debugging
		}


		int dsz = degree.size(), csz = close.size();
		int dmn = Integer.MAX_VALUE, dmx = -1;
		int cmn = dmx, cmx = dmn;
		//for min/max deg/close
		for (char x : degree.keySet()) {
			dmn = Math.min(dmn, degree.get(x));
			dmx = Math.max(dmx, degree.get(x));
		}
		for (char x : close.keySet()) {
			cmn = Math.max(cmn, close.get(x));
			cmx = Math.min(cmx, close.get(x));
			/* why am I making cmn a min and cmx a max?
			problem says we divide the number INTO the number of nodes
			so bigger number = smaller value, and vice versa */
		}


		//PRONT
		System.out.print("least degree       ");
		System.out.printf("%.2f ", dmn / 1.0 / (n-1));
		for (char x : degree.keySet()) {
			if (degree.get(x) == dmn) System.out.print(x);
		}
		System.out.println();

		System.out.print("greatest degree    ");
		System.out.printf("%.2f ", dmx / 1.0 / (n-1));
		for (char x : degree.keySet()) {
			if (degree.get(x) == dmx) System.out.print(x);
		}
		System.out.println();

		System.out.print("least closeness    ");
		System.out.printf("%.2f ", (n-1) / 1.0 / cmn);
		for (char x : close.keySet()) {
			if (close.get(x) == cmn) System.out.print(x);
		}
		System.out.println();

		System.out.print("greatest closeness ");
		System.out.printf("%.2f ", (n-1) / 1.0 / cmx);
		for (char x : close.keySet()) {
			if (close.get(x) == cmx) System.out.print(x);
		}
		System.out.println("\n---");

	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("nikita.dat"));
		while(sc.hasNextInt()) solve();
	}
}

class MultiSet { //multiset woo
	HashMap<Integer, Integer> hm;

	public MultiSet() {
		hm = new HashMap<Integer, Integer>();
	}

	void add(int x) {
		if (hm.containsKey(x)) hm.put(x, hm.get(x)+1);
		else hm.put(x, 1);
	}

	void remove(int x) {
		if (hm.get(x) > 1) hm.put(x, hm.get(x)-1);
		else hm.remove(x);
	}

	int get(int x) {
		return hm.containsKey(x) ? hm.get(x) : -1;
	}
}