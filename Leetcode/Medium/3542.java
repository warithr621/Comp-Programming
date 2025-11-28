// https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/description/?envType=daily-question&envId=2025-11-10

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int x : nums) {
            while (!st.isEmpty() && st.peek() > x) st.pop();
            if (x == 0) continue;
            if (st.empty() || st.peek() < x) {
                ans++;
                st.push(x);
            }
        }
        return ans;
    }   
}