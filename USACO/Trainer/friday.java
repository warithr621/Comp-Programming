/*
ID: warithr1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday {
	public static void main (String [] args) throws IOException {
	   // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[7];
		Arrays.fill(a, 0);
		int start = 2;
		for (int i = 1900; i < 1900 + N; i++) {
			int[] precomp = thirteen(i, start);
			for (int j = 0; j < 7; j++) a[j] += precomp[j];
			if (leap(i)) start += 2;
			else ++start;
		}
		out.printf("%d %d %d %d %d %d %d%n", a[0], a[1], a[2], a[3], a[4], a[5], a[6]);
		br.close(); out.close();
	}
	static boolean leap(int x) {
		if (x % 100 == 0) return x % 400 == 0;
		else return x % 4 == 0;
	}
	static int[] thirteen(int year, int start) {
		int[] arr = {13, 44, 72, 103, 133, 164, 194, 225, 256, 286, 317, 347};
		int[] ret = {0, 0, 0, 0, 0, 0, 0};
		if (leap(year)) for (int i = 2; i < arr.length; i++) ++arr[i];
		for (int i : arr) ret[(i + start - 1) % 7]++;
		return ret;
	}
	
}