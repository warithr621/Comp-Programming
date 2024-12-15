// https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/?envType=daily-question&envId=2024-12-12

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : gifts) pq.add(x);
        for (int i = 0; i < k; i++) {
            int v = pq.poll();
            pq.add((int)Math.sqrt(v));
        }
        long ans = 0;
        while(!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}