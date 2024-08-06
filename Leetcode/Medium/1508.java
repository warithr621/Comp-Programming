// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/?envType=daily-question&envId=2024-08-04

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = (int) (1e9) + 7;
        int[] pfx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pfx[i] = pfx[i-1] + nums[i-1];
        }
        ArrayList<Integer> subarrs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                subarrs.add(pfx[j+1] - pfx[i]);
            }
        }
        Collections.sort(subarrs);
        int ans = 0;
        for (int i = left-1; i <= right-1; i++) {
            ans = (ans + subarrs.get(i)) % MOD;
        }
        return ans;
    }

    public int slightlybetter(int[] nums, int n, int left, int right) {
        // reduces the time and memory by a bit, removes need for prefix sum
        int MOD = (int) (1e9) + 7;
        ArrayList<Integer> subarrs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarrs.add(sum);
            }
        }
        Collections.sort(subarrs);
        int ans = 0;
        for (int i = left-1; i <= right-1; i++) {
            ans = (ans + subarrs.get(i)) % MOD;
        }
        return ans;
    }
}