import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next(), T = sc.next();
		List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == 'a' && T.charAt(i) == 'b') {
				A.add(i+1);
			} else if (S.charAt(i) == 'b' && T.charAt(i) == 'a') {
				B.add(i+1);
			}
		}
		if (A.size() % 2 != B.size() % 2) {
			System.out.println(-1);
			return;
		}
		List<int[]> ans = new ArrayList<>();
		for (int i = 0; i + 1 < A.size(); i += 2) {
			ans.add(new int[]{A.get(i), A.get(i+1)});
		}
		for (int i = 0; i + 1 < B.size(); i += 2) {
			ans.add(new int[]{B.get(i), B.get(i+1)});
		}
		if (A.size() % 2 == 1) {
			ans.add(new int[]{A.get(A.size()-1), A.get(A.size()-1)});
			ans.add(new int[]{A.get(A.size()-1), B.get(B.size()-1)});
		}
		System.out.println(ans.size());
		for (int[] arr : ans) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}
}