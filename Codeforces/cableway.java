//Problem: https://codeforces.com/contest/90/problem/A
//Note: For this problem I actually made two solutions with different approaches

/*First Solution
Complexity: O(r + g + b)
Type: Simulation*/
import java.io.*;
import java.util.*;

public class cableway {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int R = Integer.parseInt(next()), G = Integer.parseInt(next()), B = Integer.parseInt(next()), ans = 0;
            while(R > 0 || G > 0 || B > 0) {
                if (ans % 3 == 0) R -= Math.min(R, 2);
                else if (ans % 3 == 1) G -= Math.min(G, 2);
                else B -= Math.min(B, 2);
                ++ans;
            }
            out.println(29 + ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}


/*Second Solution
Complexity: O(1)
Type: Mathematical*/
import java.io.*;
import java.util.*;

public class cableway {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int R = Integer.parseInt(next()), G = Integer.parseInt(next()), B = Integer.parseInt(next());
            int[] a = {(R+1) / 2 * 3 + 27,(G+1) / 2 * 3 + 28,(B + 1) / 2 * 3 + 29}; Arrays.sort(a);
            out.println(a[2]);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
