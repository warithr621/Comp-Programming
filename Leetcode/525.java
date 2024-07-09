// https://leetcode.com/problems/contiguous-array/description/


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int ans = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] == 1 ? 1 : -1;
            if (hm.containsKey(cur)) {
                ans = Math.max(ans, i - hm.get(cur));
            } else hm.put(cur, i);
        }
        return ans;
    }
}