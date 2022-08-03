import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Dinesh {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("dinesh.dat"));
		int T = 1;
		T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int x = 0;
		sc.nextLine();
		for (String s : sc.nextLine().split(" ")) {
			hm.put(s, x++);
		}
		int edges = sc.nextInt();
		int[][] adj = new int[x][x];
		for (int i = 0; i < x; i++) for (int j = 0; j < x; j++) adj[i][j] = 1000000007;
		for (int i = 0; i < edges; i++) {
			int X = hm.get(sc.next()), Y = hm.get(sc.next());
			int W = sc.nextInt();
			adj[X][Y] = adj[Y][X] = W;
		}
		for (int k = 0; k < x; k++) {
			for (int i = 0; i < x; i++) {
				for (int j = i+1; j < x; j++) {
					if (adj[i][k] + adj[k][j] < adj[i][j]) {
						adj[i][j] = adj[j][i] = adj[i][k] + adj[k][j];
					}
				}
			}
		}

		int paths = sc.nextInt();
		while(paths-->0) {
			String f = sc.next(), s = sc.next();
			int X = hm.get(f), Y = hm.get(s);
			out.printf("%s to %s:%d\n", f, s, adj[X][Y]);
		}
	}
}