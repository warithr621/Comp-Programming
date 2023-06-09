// HSCTF10 algo/largest-flagpole

import java.util.*;
import java.io.*;

public class LargestFlagpoleSolver {

	static Scanner sc; // I/O
	static PrintWriter out; // I/O

	static int N, M, cnum[], ans = 0;
	static ArrayList[] comps;
	static HashMap<Integer, ArrayList<Integer>> graph;
	static Stack<Integer> st;
	static ArrayList<Integer> cyc;
	static HashSet<ArrayList<Integer>> cycles;
	static boolean[][] clownvis;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileReader("data.txt"));
		out = new PrintWriter("out.txt");
		int T = sc.nextInt();
		while(T --> 0) {
			// re-initialize everything
			comps = new ArrayList[1];
			graph = new HashMap<>();
			st = new Stack<>();
			cyc = new ArrayList<>();
			cycles = new HashSet<>();
			clownvis = new boolean[1][1];
			ans = 0;
			// i don't think this changes anything, but just in case
			solve();
		}
		sc.close(); out.close();
	}

	static void solve() throws IOException {

		parseInput(); // takes in all input + sets up graph
		findComponents(); // sort all components in graph

		// size = (nodes in flag)^2 + (nodes in pole)
		// note that by logic, a flag has to be at least 5 nodes
		for (int i = 1; i < comps.length; i++) {
			// testing the 'i'th component
			if (comps[i].size() < 5) continue;
			
			cycles = new HashSet<>();
			cyc = new ArrayList<>();

			int v = (Integer) comps[i].get(0);
			st = new Stack<>();
			clownvis = new boolean[N+1][N+1];
			dfs(v, v, -1);
			// System.out.println(cycles);

			if (cycles.size() != 1) {
				// either no cycles or multiple cycles
				continue;
			}

			// time to figure out if there's a pole I guess
			// theoretically if there's a pole
				// by definition there should only be one node in the cycle with degree 3
				// I think that might be enough
				// oh and also check divisibility, what am I doing

			ArrayList<Integer> flag = cycles.iterator().next();
			if (flag.size() % 4 != 0) {
				continue;
			}


			int deg3 = 0, deg3node = 0;
			for (int node : flag) {
				if (graph.get(node).size() == 3) {
					++deg3;
					deg3node = node;
				}
			}

			if (deg3 == 1) {
				// now use this node and traverse it, make sure a POLE is connected
				boolean pole = true;
				int curnode = -1;
				int cntr = 0;
				for (int j = 0; j < 3; j++) {
					// find node of degree 2
					if (!flag.contains( graph.get(deg3node).get(j) )) {
						curnode = graph.get(deg3node).get(j);
						++cntr;
					}
				}
				if (cntr != 1) {
					pole = false;
				}
				// System.out.println(deg3node + " CURNODE " + curnode + pole);
				int prev = deg3node;
				while(pole && graph.get(curnode).size() != 1) {
					if (graph.get(curnode).size() > 2) {
						pole = false;
						continue;
					}
					int tmp = curnode;
					// System.out.println("Options: " + graph.get(curnode).get(0) + " " + graph.get(curnode).get(1));
					if (graph.get(curnode).get(0) != prev) {
						curnode = graph.get(curnode).get(0);
					} else {
						curnode = graph.get(curnode).get(1);
					}

					prev = tmp;
					// System.out.println(prev + " " + curnode);
				}

				if (pole) {
					// finally, we're done and this is a flag
					int F = flag.size(), P = comps[i].size() - F;
					ans = Math.max(ans, F * F + P);
				}
			}
		}

		out.println(ans);
		System.out.println(ans);
	}

	static void dfs(int init, int cur, int prev) {
		if (clownvis[init][cur]) {
			for (int i = 0; i < st.size(); i++) {
				if (st.get(i) == cur) {
					for (int j = i; j < st.size(); ++j) {
						cyc.add(st.get(j));
					}
				}
			}
			Collections.sort(cyc);
			if (cyc.size() > 2)	cycles.add(cyc);
			cyc = new ArrayList<>();
			return;
		}
		clownvis[init][cur] = true;
		st.push(cur);
		for (int dest : graph.get(cur)) {
			if (prev == dest) continue;
			dfs(init, dest, cur);
		}
		st.pop();
		return;
	}

	static void findComponents() {
		cnum = new int[N+1]; // cnum[i] is component number of node 'i'
		// comps will be defined later to host all nodes in each component
		int cur = 1; // component # tracker

		boolean[] vis = new boolean[N+1]; // classic vis array
		Queue<Integer> q = new LinkedList<>(); // BFS because why not
		
		for (int i = 1; i <= N; i++) {
			if (cnum[i] != 0) {
				continue; // already defined
			}
			q.add(i);
			while(!q.isEmpty()) {
				int node = q.poll();
				vis[node] = true;
				cnum[node] = cur;
				for (Integer x : graph.get(node)) {
					if (!vis[x]) q.add(x);
				}
			}
			++cur; // increment number of components
		}

		// total number of components = cur - 1
		comps = new ArrayList[cur];
		for (int i = 1; i < cur; i++) comps[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			comps[cnum[i]].add(i);
		}

		// for (int i = 1; i < cur; i++) {
		// 	System.out.println(i + " " + comps[i]);
		// }
	}

	static void parseInput() throws IOException {
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			// remember this is undirected
			int U = sc.nextInt(), V = sc.nextInt();
			place(U, V);
			place(V, U);
		}
	}

	static void place(int src, int dest) {
		ArrayList<Integer> tmp = graph.get(src);
		tmp.add(dest);
		graph.put(src, tmp);
	}
}