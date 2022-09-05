// https://codeforces.com/contest/1654/problem/C

import java.util.*;
import static java.lang.System.*;

public class AliceAndCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            PriorityQueue<Long> A = new PriorityQueue<>(Collections.reverseOrder());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long l = sc.nextLong();
                A.add(l);
                sum += l;
            }
            PriorityQueue<Long> B = new PriorityQueue<>(Collections.reverseOrder());
            B.add(sum);
            while(!A.isEmpty() && !B.isEmpty()) {
                long amx = A.peek(), bmx = B.peek();
                if (bmx < amx) break;
                if (bmx == amx) {
                    A.poll(); 
                    B.poll();
                    // out.println("EQ");
                } else {
                    B.poll();
                    B.add(bmx / 2);
                    B.add((bmx+1) / 2);
                    // out.println("GE");
                }
            }
            
            out.println(A.isEmpty() && B.isEmpty() ? "YES" : "NO");
        }
    }
}