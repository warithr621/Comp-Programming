// https://leetcode.com/problems/continuous-subarrays/description/?envType=daily-question&envId=2024-12-14

class Solution {
    public long continuousSubarrays(int[] nums) {
        int L = 0, R = 0;
        long ans = 0;
        Queue<Integer> mn = new PriorityQueue<>((a,b) -> nums[a] - nums[b]);
        Queue<Integer> mx = new PriorityQueue<>((a,b) -> nums[b] - nums[a]);
        while (R < nums.length) {
            mn.add(R);
            mx.add(R);
            while (L < R && nums[mx.peek()] - nums[mn.peek()] > 2) {
                ++L;
                while (!mx.isEmpty() && mx.peek() < L) mx.poll();
                while (!mn.isEmpty() && mn.peek() < L) mn.poll();
            }
            ans += R - L + 1L;
            ++R;
        }
        return ans;
    }
}