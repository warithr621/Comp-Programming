// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/description/?envType=daily-question&envId=2025-01-26

class Solution {

    private int bfs(int n, Set<Integer> vis, List<List<Integer>> radj) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        int mx = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int src = cur[0], dist = cur[1];
            for (int dest : radj.get(src)) {
                if (vis.contains(dest)) continue;
                vis.add(dest);
                q.add(new int[]{dest, dist + 1});
                mx = Math.max(mx, dist + 1);
            }
        }
        return mx;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> radj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            radj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            radj.get(favorite[i]).add(i);
        }

        int a1 = 0, a2 = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Map<Integer, Integer> v = new HashMap<>();
                int cur = i;
                int dist = 0;
                while (true) {
                    if (vis[cur]) break;
                    vis[cur] = true;
                    v.put(cur, dist++);
                    int nxt = favorite[cur];
                    if (v.containsKey(nxt)) {
                        int len = dist - v.get(nxt);
                        a1 = Math.max(a1, len);
                        if (len == 2) {
                            Set<Integer> viss = new HashSet<>();
                            viss.add(cur);
                            viss.add(nxt);
                            a2 += 2 + bfs(nxt, viss, radj) + bfs(cur, viss, radj);
                        }
                        break;
                    }
                    cur = nxt;
                }
            }
        }
        return Math.max(a1, a2);
    }

}