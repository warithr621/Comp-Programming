// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/?envType=daily-question&envId=2025-02-13

class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> pq = new PriorityQueue<>();
        for (int x : nums) pq.add((long) x);
        int ans = 0;
        while (pq.peek() < k) {
            ++ans;
            long x = pq.poll(), y = pq.poll();
            pq.add(Math.min(x,y) * 2 + Math.max(x,y));
        }
        return ans;
    }
}