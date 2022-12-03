// AoC 2022 D3

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Rucksack2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;
		
		ArrayList<String> al = new ArrayList<>();
		while(sc.hasNext()) al.add(sc.next());
		
		for (int tt = 0; tt < al.size(); tt += 3) {
		    String a = al.get(tt), b = al.get(tt+1), c = al.get(tt+2);
		    for (int i = 0; i < a.length(); i++) {
		        if (b.indexOf(a.charAt(i)) != -1 && c.indexOf(a.charAt(i)) != -1) {
		          //  out.println(a.charAt(i));
		            ans += (a.charAt(i) >= 'a' ? a.charAt(i) - 'a' + 1 : a.charAt(i) - 'A' + 27);
		          //  out.println(ans);
		            break;
		        }
		    }
		}
		
		out.println(ans);
	}
}