// https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2024-10-03

class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = nums.length;
        int s = 0;
        for (int x : nums) s = (s + x) % p;
        s %= p;
        if (s == 0) return 0;
        int cur = 0;
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            cur = (cur + x) % p;
            if (hm.containsKey((cur - s + p) % p)) {
                ans = Math.min(ans, i - hm.get((cur - s + p) % p));
            } 
            hm.put(cur, i);
        }
        if (cur == 0) return 0;
        return ans == nums.length ? -1 : ans;
    }
}