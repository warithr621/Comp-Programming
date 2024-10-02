// 2021 NAQ: Common Factors

import java.util.*;

public class C {

    static long gcd(long a, long b) {
        if (b == 0L) return a;
        return gcd(b, a % b);
    }

    static boolean prime(int x) {
        if (x <= 1) return false;
        if (x <= 3) return true;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long cur = 1;
        for (int i = 2; i <= 50; i++) {
            if (prime(i)) {
                if (cur * i > N) break;
                cur *= i;
            }
        }
        long rel = cur;
        for (int i = 2; i <= 50; i++) {
            if (prime(i) && rel % i == 0) {
                rel = rel / i * (i-1);
            }
        }
        rel = cur - rel;
        long g = gcd(rel, cur);
        System.out.printf("%d/%d", rel/g, cur/g);
    }
}