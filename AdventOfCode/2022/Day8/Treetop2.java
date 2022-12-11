// AoC 2022 D8

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Treetop2 {
    
    public static int func(int x, int y, int dx, int dy, ArrayList<String> al) {
        int z = al.get(x).charAt(y) - '0';
        x += dx; y += dy;
        int res = 0;
        for (; x >= 0 && y >= 0 && x < al.size() && y < al.get(0).length(); x += dx, y += dy) {
            ++res;
            if (al.get(x).charAt(y) - '0' >= z) break;
        }
        return res;
    }
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int mx = 0;

		ArrayList<String> al = new ArrayList<>();
		while(sc.hasNext()) al.add(sc.next());
		for (int i = 1; i < al.size() - 1; i++) {
		    for (int j = 1; j < al.get(i).length()-1; ++j) {
		        mx = Math.max(mx, func(i,j,1,0,al) * func(i,j,-1,0,al) * func(i,j,0,1,al) * func(i,j,0,-1,al));
		    }
		}
		
		out.println(mx);
	}
}