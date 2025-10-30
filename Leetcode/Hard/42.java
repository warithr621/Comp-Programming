// https://leetcode.com/problems/trapping-rain-water/description/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lmax = height[left], rmax = height[right];
        int ans = 0;
        while (left < right) {
            if (lmax < rmax) {
                ++left;
                lmax = Math.max(lmax, height[left]);
                ans += lmax - height[left];
            } else {
                --right;
                rmax = Math.max(rmax, height[right]);
                ans += rmax - height[right];
            }
        }
        return ans;
    }
}