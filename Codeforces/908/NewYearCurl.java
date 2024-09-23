// https://codeforces.com/contest/908/problem/C

import java.util.*;

public class NewYearCurl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), r = sc.nextInt();
		ArrayList<Circle> al = new ArrayList<>();
		int tmp = sc.nextInt();
		al.add(new Circle(r, tmp, r));
		for (int i = 1; i < n; i++) {
			int x = sc.nextInt();
			double possibleY = r; // chance it hits none of the circles
			for (int j = 0; j < al.size(); j++) {
				// do these circles hit? if not skip it
				double horiz = Math.abs(x - al.get(j).x);
				if (horiz > 2*r) continue;
				if (horiz == 2*r) {
					possibleY = Math.max(possibleY, al.get(j).y);
					continue;
				}
				// this assumes the circles hit, but not when they're touching like this: oo
				double ydiff = Math.sqrt(4*r*r - horiz*horiz);
				possibleY = Math.max(possibleY, al.get(j).y + ydiff);
			}
			al.add(new Circle(r, x, possibleY));
		}
		for (Circle c : al) {
			System.out.print(c.y + " ");
		}
	}
}

class Circle {
	double r, x, y;
	Circle(double r, double x, double y) {
		this.r = r;
		this.x = x;
		this.y = y;
	}

}