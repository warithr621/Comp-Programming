class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[][] vis = new boolean[n][2];
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] start = new int[]{node1, node2};
        for (int i = 0; i < 2; i++) {
            q.offer(new int[]{start[i], 0});
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int node = tmp[0], d = tmp[1];
                if (vis[node][i]) continue;
                vis[node][i] = true;
                dist[node][i] = d;
                if (edges[node] != -1 && !vis[edges[node]][i]) {
                    q.offer(new int[]{edges[node], d+1});
                }
            }
        }
        int ans = -1, best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(dist[i]));
            int dd = Math.max(dist[i][0], dist[i][1]);
            if (dd < best) {
                ans = i;
                best = dd;
            }
        }
        return ans;
    }
}