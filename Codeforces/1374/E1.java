// https://codeforces.com/contest/1374/problem/E1

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class ReadBooksEasy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		ArrayList<Integer> arr[] = new ArrayList[4];
		for (int i = 0; i < 4; i++) arr[i] = new ArrayList<>();
		//[0] = 00, [1] = 01, [2] = 10, [3] = 11
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
			if (a == 0) arr[b == 0 ? 0 : 1].add(t);
			else arr[b == 0 ? 2 : 3].add(t);
		}
		for (int i = 0; i < 4; i++) Collections.sort(arr[i]);
		int j = 0;
		while(j < arr[1].size() && j < arr[2].size()) {
			arr[3].add(arr[1].get(j) + arr[2].get(j));
			++j;
		}
		if (arr[3].size() < k) out.println(-1);
		else {
			Collections.sort(arr[3]);
			int sum = 0;
			for (int i = 0; i < k; i++) sum += arr[3].get(i);
			out.println(sum);
		}
	}
}