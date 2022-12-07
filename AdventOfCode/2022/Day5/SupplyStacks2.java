// AoC 2022 D5

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class SupplyStacks2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		
		List<String> st = Arrays.asList(new String[]{"","","","","","","","",""});
		
		while(true) {
			String s = sc.nextLine();
			if (s.substring(0,3).equals(" 1 ")) break;
			for (int i = 0; i < s.length(); i += 4) {
				if (s.charAt(i) == ' ') continue;
				st.set(i/4, s.charAt(i+1) + st.get(i/4));
			}
		} sc.nextLine();

		while(sc.hasNextLine()) {
			String[] tmp = sc.nextLine().split(" ");
			int t = Integer.parseInt(tmp[1]);
			int o = Integer.parseInt(tmp[3])-1;
			int n = Integer.parseInt(tmp[5])-1;

			st.set(n, st.get(n) + st.get(o).substring(st.get(o).length()-t));
			st.set(o, st.get(o).substring(0, st.get(o).length()-t));
		}

		for (String s : st) out.print(s.charAt(s.length()-1));
	}
}