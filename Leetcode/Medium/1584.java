// https://leetcode.com/problems/min-cost-to-connect-all-points/description/

class Solution {

    public static int dist(int[] a, int[][] points) {
        return Math.abs(points[a[0]][0] - points[a[1]][0]) + Math.abs(points[a[0]][1] - points[a[1]][1]);
    }

    public int minCostConnectPoints(int[][] points) {
        // I have now learned Prim's from GFG, let's see if I can impl it
        int n = points.length;
        HashSet<Integer> inc = new HashSet<>();
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return dist(a, points) - dist(b, points);
            }
        });
        inc.add(0);
        for (int i = 1; i < n; i++) {
            pq.add(new int[]{0, i});
        }
        while (inc.size() != n) {
            int[] edge = pq.poll();
            if (!inc.contains(edge[0])) {
                inc.add(edge[0]);
                for (int i = 0; i < n; i++) {
                    if (i == edge[1]) continue;
                    pq.add(new int[]{edge[0], i});
                }
                ans += dist(edge, points);
            } else if (!inc.contains(edge[1])) {
                inc.add(edge[1]);
                for (int i = 0; i < n; i++) {
                    if (i == edge[0]) continue;
                    pq.add(new int[]{edge[1], i});
                }
                ans += dist(edge, points);
            }
        }
        return ans;
    }
}