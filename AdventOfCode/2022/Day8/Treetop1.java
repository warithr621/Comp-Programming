// AoC 2022 D8

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Treetop1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int ans = 0;

		ArrayList<String> al = new ArrayList<>();
		while(sc.hasNext()) al.add(sc.next());
		for (int i = 0; i < al.size(); i++) {
		    if (i == 0 || i + 1 == al.size()) {
		        ans += al.get(i).length();
		        continue;
		    }
		    ans += 2;
		    for (int j = 1; j < al.get(i).length()-1; ++j) {
		        boolean U = true, D = true, L = true, R = true;
		        for (int k = j-1; k >= 0; --k) L &= al.get(i).charAt(j) > al.get(i).charAt(k);
		        for (int k = j+1; k < al.get(i).length(); ++k) R &= al.get(i).charAt(j) > al.get(i).charAt(k);
		        for (int k = i-1; k >= 0; --k) U &= al.get(i).charAt(j) > al.get(k).charAt(j);
		        for (int k = i+1; k < al.size(); ++k) D &= al.get(i).charAt(j) > al.get(k).charAt(j);
		        ans += (L | R | U | D ? 1 : 0);
		      //  out.println(i + " " + j + " " + L + R + U + D);
		    }
		}
		
		out.println(ans);
	}
}