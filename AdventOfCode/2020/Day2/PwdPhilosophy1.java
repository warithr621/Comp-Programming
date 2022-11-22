// AoC 2020 D2

import java.util.*;
import java.io.*;

public class PwdPhilosophy1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;

		while(sc.hasNext()) {
			String[] tmp = sc.next().split("-");
			int L = Integer.parseInt(tmp[0]), R = Integer.parseInt(tmp[1]);
			char c = sc.next().charAt(0);
			String s = sc.next();

			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == c) ++cnt;
			}

			if (L <= cnt && cnt <= R) ++ans;
		}

		System.out.println(ans);
	}
}