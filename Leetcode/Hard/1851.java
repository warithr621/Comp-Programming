// https://leetcode.com/problems/minimum-interval-to-include-each-query/description/

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[][] queriesIndexed = new int[m][2];
        for (int i = 0; i < m; i++) {
            queriesIndexed[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queriesIndexed, (a,b) -> a[0] - b[0]);

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // elements will be [size, rightmost element]
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int i = 0, j = 0; j < m; j++) {
            // add as many things as possible depending on left
            while (i < n && intervals[i][0] <= queriesIndexed[j][0]) {
                int sz = intervals[i][1] - intervals[i][0] + 1;
                pq.add(new int[]{sz, intervals[i][1]});
                i++;
            }
            // remove things as needed depending on right
            while (!pq.isEmpty() && pq.peek()[1] < queriesIndexed[j][0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[queriesIndexed[j][1]] = pq.peek()[0];
            }
        }

        return ans;
    }
}