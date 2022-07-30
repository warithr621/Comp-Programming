// https://codeforces.com/contest/977/problem/D
// Virtual

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class DivThreeMultTwo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    
    static long pow3(long x) {
        long ans = 0;
        while(x % 3 == 0) {
            x /= 3;
            ++ans;
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        int n = (int) nextl();
        Long[][] a = new Long[n][2];
        for (int i = 0; i < n; i++) a[i][0] = nextl();
        for (int i = 0; i < n; i++) a[i][1] = pow3(a[i][0]);
        Arrays.sort(a, new Comparator<Long[]>() {
            public int compare(Long[] a, Long[] b) {
                if (a[1] > b[1]) return -1;
                if (a[1] < b[1]) return 1;
                if (a[0] < b[0]) return -1;
                return 1;
            }
        });
        for (Long[] i : a) out.print(i[0] + " ");
    }
    
    static long nextl() throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }
}