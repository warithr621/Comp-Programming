// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=daily-question&envId=2024-10-08

class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int sum = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '[')
                ++sum;
            else {
                if (sum > 0)
                    sum--;
                else {
                    ++sum;
                    ++ans;
                }
            }
        }
        return ans;
    }
}