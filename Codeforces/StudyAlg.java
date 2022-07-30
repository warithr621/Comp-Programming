// https://codeforces.com/gym/102951/problem/B

import java.io.*;
import java.util.*;

public class StudyAlg {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			a.add(Integer.parseInt(st.nextToken()) );
		}
		Collections.sort(a);
		int count = 0; int time = 0;
		while (count < N && time + a.get(count) <= X) {
			time += a.get(count);
			count++;
		}
		System.out.print(count);
	}
}
