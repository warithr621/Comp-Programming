// 2019 Feb Silver P3

import java.util.*;
import java.io.*;

public class GreatReveg {
	static Scanner sc;
	static PrintWriter out;
	static int n,m;
	static boolean[] vis;
	static ArrayList<Integer> same[], diff[];
	static int grass[];

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new File("revegetate.in"));
		out = new PrintWriter("revegetate.out");

		n = sc.nextInt(); m = sc.nextInt();
		same = new ArrayList[n]; diff = new ArrayList[n];
		vis = new boolean[n];
		grass = new int[n];

		for (int i = 0; i < n; i++) {
			same[i] = new ArrayList<>();
			diff[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			char c = sc.next().charAt(0);
			int x = sc.nextInt()-1, y = sc.nextInt()-1;
			if (c == 'S') {
				same[x].add(y);
				same[y].add(x);
			} else {
				diff[x].add(y);
				diff[y].add(x);
			}
		}

		int z = 0;
		boolean works = true;

		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				//run DF--wait no, BFS >:)
				Queue<Integer[]> q = new LinkedList<Integer[]>();
				q.offer(new Integer[]{i, 1});
				while(!q.isEmpty()) {
					Integer[] src = q.poll();
					int x = src[0], y = src[1];
					grass[x] = y;
					vis[x] = true;
					// out.println(x + " " + y);
					for (int dest : same[x]) {
						if (grass[dest] == 3 - grass[x]) {
							//i.e. 1 and 2 or 2 and 1
							works = false;
						}
						if (grass[dest] == 0) {
							q.offer(new Integer[]{dest, grass[x]});
						}
					}
					for (int dest : diff[x]) {
						if (grass[dest] == grass[x]) {
							//i.e. 1 and 1 or 2 and 2
							works = false;
						}
						if (grass[dest] == 0) {
							q.offer(new Integer[]{dest, 3 - grass[x]});
						}
					}
					// out.println("iter done");
				}
				++z;
			}
		}

		if (!works) out.println(0);
		else {
			out.print(1);
			while(z-->0) out.print(0);
		}

		out.close();
	}
}