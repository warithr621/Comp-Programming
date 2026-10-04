// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/?envType=daily-question&envId=2026-07-27

class Solution {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            if (x > a) {
                b = a;
                a = x;
            } else if (x > b) {
                b = x;
            }
        }
        return (a - 1) * (b - 1);
    }
}