// AoC 2022 D3

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Rucksack1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;
		
		while(sc.hasNext()) {
		    String tmp = sc.next();
		    String a = tmp.substring(0, tmp.length()/2), b = tmp.substring(tmp.length()/2);
		  //  out.println(a + " " + b);
		    for (int i = 0; i < a.length(); i++) {
		        if (b.indexOf(a.charAt(i)) != -1) {
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