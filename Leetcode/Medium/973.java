// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(points.length, (a,b) -> Integer.compare(a[2],b[2]));
        for (int[] arr : points) pq.add(new int[]{arr[0], arr[1], arr[0]*arr[0] + arr[1]*arr[1]});
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = new int[]{pq.peek()[0], pq.peek()[1]};
            pq.poll();
        }
        return ans;
    }
}