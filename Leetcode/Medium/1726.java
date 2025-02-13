// https://leetcode.com/problems/tuple-with-same-product/description/?envType=daily-question&envId=2025-02-06

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int tmp = nums[i] * nums[j];
                f.put(tmp, f.getOrDefault(tmp, 0) + 1);
            }
        }
        int ans = 0;
        for (int x : f.keySet()) {
            int y = f.get(x);
            ans += y * (y-1) / 2 * 8;
            // System.out.println(x + " " + f.get(x));
        }
        return ans;
    }
}