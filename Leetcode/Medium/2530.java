// https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2024-10-14

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) pq.add((long) x);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += pq.peek();
            pq.add((pq.poll() + 2) / 3);
        }
        return ans;
    }
}