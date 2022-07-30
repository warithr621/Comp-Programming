// 2017 Open Silver P1

import java.util.*;
// import static java.lang.System.*;
import java.io.*;

public class PairedUp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("pairup.in"));
        // Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter("pairup.out");
        int n = sc.nextInt();
        Long[][] a = new Long[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextLong();
            a[i][1] = sc.nextLong();
        }
        Arrays.sort(a, new Comparator<Long[]>() {
            public int compare(Long[] a, Long[] b) {
                if (a[1] < b[1]) return -1;
                if (a[1] > b[1]) return 1;
                return a[0] < b[0] ? -1 : 1;
            }
        });
        // for (Long[] x : a) out.println(Arrays.toString(x));
        int curl = 0, curr = n-1;
        long ans = -1;
        while(curl <= curr) {
            long x = Math.min(a[curl][0], a[curr][0]);
            if (curl == curr) x /= 2;
            ans = Math.max(ans, a[curl][1] + a[curr][1]);
            a[curl][0] -= x; a[curr][0] -= x;
            if (a[curl][0] == 0) ++curl;
            if (a[curr][0] == 0) --curr;
        }
        out.println(ans);
        out.close();
    }
}