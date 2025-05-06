// https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/?envType=daily-question&envId=2025-04-22

class Solution {

    static long MOD = 1_000_000_007;
    static long[][] comb = new long[10020][16];
    static long[] sieve = new long[10005];
    static List<Integer>[] primeCounts = new List[10005]; // prime factorization

    Solution() {
        if (comb[0][0] == 1) return; // avoid multiple calls
        for (int i = 0; i < 10005; i++) primeCounts[i] = new ArrayList<>();
        for (int i = 2; i < 10005; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j < 10005; j += i) {
                    if (sieve[j] == 0) sieve[j] = i; // largest prime factor
                }
            }
        }
        for (int i = 2; i < 10005; i++) {
            int x = i;
            while (x > 1) {
                long p = sieve[x]; int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                primeCounts[i].add(cnt);
            }
        }
        comb[0][0] = 1;
        for (int i = 1; i < 10020; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 15); j++) {
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % MOD; // i love dp
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        // let the array be a1, a2, ..., an
        // we want a1 | a2, a2 | a3, ...
        // let k1 = a2/a1, k2 = a3/a2, ...
        // clearly, the product of all (n-1) k's is equal to an / a1
        // this should end up being stars and bars
        long ans = 0;
        for (int start = 1; start <= maxValue; start++) {
            long cur = 1;
            for (int p : primeCounts[start]) {
                cur = cur * comb[n + p - 1][p] % MOD;
            }
            ans = (ans + cur) % MOD;
        }
        return (int) ans;
    }
}