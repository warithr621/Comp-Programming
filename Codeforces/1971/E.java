import java.util.*;
import java.io.*;

public class E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T --> 0) {
			int N = sc.nextInt(), K = sc.nextInt(), Q = sc.nextInt();
			long[] A = new long[K+1], B = new long[K+1];
			for (int i = 1; i <= K; i++) A[i] = sc.nextInt(); // loc
			for (int i = 1; i <= K; i++) B[i] = sc.nextInt(); // time
			while (Q --> 0) {
				int D = sc.nextInt();
				if (D == 0) {
					out.print(0 + " ");
					continue; // just get this out of the way
				}
				if (D == N) {
					out.print(B[K] + " ");
					continue; // also just get this out of the way
				}
				// find the biggest element in A that is at most D
				int idx = Arrays.binarySearch(A, D);
				if (idx < 0) idx = ~idx;
				--idx;
				long additional = D - A[idx];
				long time = B[idx] + additional * (B[idx+1] - B[idx]) / (A[idx+1] - A[idx]);
				out.print(time + " ");
			}
			out.println();
		}
		out.close();
	}
}