// https://leetcode.com/problems/find-target-indices-after-sorting-array/description/


class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int L = 0, R = 0; // less than, greater than
        for (int x : nums) {
            if (x < target) ++L;
            else if (x > target) ++R;
        }
        for (int i = L; i < nums.length - R; i++) {
            ans.add(i);
        }
        return ans;
    }
}