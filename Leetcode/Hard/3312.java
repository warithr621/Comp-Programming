// https://leetcode.com/problems/sorted-gcd-pair-queries/?envType=daily-queAstion&envId=2026-07-17

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int MAX = 0;
        for (int x : nums) {
            MAX = Math.max(MAX, x);
        }
        long[] freq = new long[MAX+1];
        for (int x : nums) {
            freq[x]++; // freq[i] = # of elements equal to i
        }
        for (int i = 1; i <= MAX; i++) {
            for (int j = 2*i; j <= MAX; j += i) {
                freq[i] += freq[j]; // freq[i] = # of elements divisible by i
            }
        }
        for (int i = 1; i <= MAX; i++) {
            freq[i] = freq[i] * (freq[i] - 1) / 2; // freq[i] = # of pairs whose gcd is divisible by i
        }
        for (int i = MAX; i >= 1; i--) {
            for (int j = 2*i; j <= MAX; j += i) {
                freq[i] -= freq[j]; // freq[i] = # of pairs whose gcd is i
            }
        }
        for (int i = 1; i <= MAX; i++) {
            freq[i] += freq[i-1]; // freq[i] = # of pairs whose gcd is <= i
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int left = 1, right = MAX;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (freq[mid] < queries[i] + 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            ans[i] = left;
        }
        return ans;
    }
}