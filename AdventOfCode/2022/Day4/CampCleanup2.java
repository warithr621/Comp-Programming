// AoC 2022 D4

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class CampCleanup2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;
		
		while(sc.hasNext()) {
		    String[] s = sc.next().split("[-,]");
		    int[] a = new int[4];
		    for (int i = 0; i < 4; i++) a[i] = Integer.parseInt(s[i]);
		    
		    if (a[0] <= a[3] && a[2] <= a[1] || a[2] <= a[1] && a[0] <= a[3]) ++ans;
		}
		
		out.println(ans);
	}
}