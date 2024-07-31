// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        for (int x : hm.keySet()) {
            if (hm.get(x) == 2) ans ^= x;
        }
        return ans;
    }

    public int faster(int[] nums) {
        // although this is N^2, this runs faster (I believe since N is so small)
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) ans ^= nums[i];
            }
        }
        return ans;
    }
}