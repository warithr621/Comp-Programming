import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		DSU dsu = new DSU(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[K];
			for (int j = 0; j < K; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j < K; j++) {
				dsu.union(arr[0], arr[j]);
			}
		}
		for (int i = 1; i <= N; i++) {
			out.print(dsu.size(i) + " ");
		}
		br.close(); out.close();
	}
}

class DSU {
	private int[] parent, size;

	public DSU(int N) {
		parent = new int[N+1];
		size = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			if (size[rootX] < size[rootY]) {
				parent[rootX] = rootY;
				size[rootY] += size[rootX];
			} else {
				parent[rootY] = rootX;
				size[rootX] += size[rootY];
			}
		}
	}

	public int size(int x) {
		return size[find(x)];
	}

}