// 2021 NAQ: Mr. Code Format Grader

import java.util.*;

public class G {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(), N = sc.nextInt();
		boolean[] bad = new boolean[C+1];
		for (int i = 0; i < N; i++) {
			int X = sc.nextInt();
			bad[X] = true;
		}
		int start = 1;
		boolean state = bad[start];
		List<Integer> valid = new ArrayList<>(), invalid = new ArrayList<>();
		for (int i = 1; i <= C; i++) {
			if (bad[i] != state) {
				if (state) {
					invalid.add(start);
					invalid.add(i - 1);
				} else {
					valid.add(start);
					valid.add(i - 1);
				}
				start = i;
				state = !state;
			}
		}
		if (state) {
			invalid.add(start);
			invalid.add(C);
		} else {
			valid.add(start);
			valid.add(C);
		}
		System.out.print("Errors: ");
		print(invalid);
		System.out.print("\nCorrect: ");
		print(valid);
	}

	static void print(List<Integer> al) {
		if (al.size() == 2) {
			System.out.print(span(al.get(0), al.get(1)));
			return;
		}
		for (int i = 0; i < al.size(); i += 2) {
			System.out.print(span(al.get(i), al.get(i+1)));
			if (i + 4 == al.size()) System.out.print(" and ");
			else if (i + 2 != al.size()) System.out.print(", ");
		}
	}

	static String span(int x, int y) {
		if (x == y) return Integer.toString(x);
		else return x + "-" + y;
	}
}