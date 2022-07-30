// https://codeforces.com/problemset/problem/1137/D

import java.util.*;

public class CoopGame {
	
	static Scanner sc = new Scanner(System.in);
	//initialize scanner here so we can use for read()
	static int[] v = new int[10];
	//keeps track of the vertices each digit is at

	static void read() {
		int N = sc.nextInt(); //number of groups
		for (int i = 0; i < N; i++) {
			String s = sc.next(); //the vertices at vertex 'i'
			for (int j = 0; j < s.length(); j++) {
				v[s.charAt(j) - '0'] = i;
				//mark the relative vertex each person is at
			}
		}
	}

	static void query(int[] arr) {
		//performs a query
		System.out.print("next ");
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
		System.out.flush();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//first, use friends 0 and 1 as hare and tortoise
		while(true) {
			query(new int[]{0,1});
			read();
			query(new int[]{0});
			read();
			if (v[0] == v[1]) {
				//'0' and '1' are on the same vertex
				break;
			}
		}
		/*next part is to now move everything
		until they're on the same vertex via cycling*/
		while(true) {
			query(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
			read();
			if (v[0] == v[2]) {
				/*this means that '2' through '9' caught up to '0'
				so now we can break*/
				break;
			}
		}
		//should be done now, so...
		System.out.println("done");
		System.out.flush();
	}
}
