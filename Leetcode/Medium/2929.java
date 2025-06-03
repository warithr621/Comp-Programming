// https://leetcode.com/problems/distribute-candies-among-children-ii/description/?envType=daily-question&envId=2025-06-01

class Solution {

    public static long C(long n) {
        if (n < 0) return 0;
        return (n * (n-1)) >> 1;
    }

    public long distributeCandies(int n, int limit) {
        return C(n+2) - 3 * C(n + 2 - (limit + 1)) + 3 * C(n + 2 - (limit + 1) * 2) - C(n + 2 - 3 * (limit + 1));
    }
}