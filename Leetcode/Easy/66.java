// https://leetcode.com/problems/plus-one/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[] plusOne(int[] digits) {
        boolean nines = true;
        int n = digits.length;
        for (int x : digits) nines &= x == 9;
        int[] ans = new int[nines ? n+1 : n];
        if (nines) ans[0] = 1;
        int carry = 1;
        for (int i = 1; i <= n; i++) {
            int x = digits[n - i] + carry;
            carry = x / 10;
            ans[ans.length - i] = x % 10;
        }
        return ans;
    }
}