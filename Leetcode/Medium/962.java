// https://leetcode.com/problems/maximum-width-ramp/editorial/?envType=daily-question&envId=2024-10-10

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[st.peek()] > nums[i])
                st.push(i);
        }
        // increasing order of stuff

        int ans = 0;
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                ans = Math.max(ans, i - st.pop());
        }
        return ans;
    }
}