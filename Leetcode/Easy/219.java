// https://leetcode.com/problems/contains-duplicate-ii/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        // number, latest index
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (i - hm.getOrDefault(x, -1000000) <= k) return true;
            hm.put(x, i);
        }
        return false;
    }
}