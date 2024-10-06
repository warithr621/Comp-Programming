// https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int cur = 0;
        hm.put(0, 1);
        for (int x : nums) {
            cur += x;
            ans += hm.getOrDefault(cur - k, 0);
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
            // System.out.println(hm);
        }
        return ans;
    }
}