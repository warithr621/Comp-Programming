// https://leetcode.com/problems/minimum-index-of-a-valid-split/?envType=daily-question&envId=2025-03-27

class Solution {
    public int minimumIndex(List<Integer> nums) {
        // find mode
        int mode = nums.get(0), cnt = 0, n = nums.size();
        for (int x : nums) {
            if (x == mode) ++cnt;
            else --cnt;

            if (cnt == 0) {
                mode = x;
                cnt = 1;
            }
        }

        int f = 0;
        for (int x : nums) {
            if (x == mode) ++f;
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == mode) ++cnt;
            if (cnt * 2 > i + 1 && (f-cnt) * 2 > n - i - 1) return i;
        }
        return -1;
    }
}