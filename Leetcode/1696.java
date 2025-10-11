// https://leetcode.com/problems/jump-game-vi/description/

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        ArrayDeque<Integer> dq = new ArrayDeque<>(); // at most k elements
        dq.add(0);
        for (int i = 1; i < n; i++) {
            // we could hop to here anywhere from nums[i-1] to nums[i-k]
            if (dq.peek() < i-k) dq.poll();
            dp[i] = nums[i] + dp[dq.peek()];
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
            dq.add(i);
        }
        return dp[n-1];
    }
}