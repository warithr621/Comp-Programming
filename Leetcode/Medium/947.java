// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/?envType=daily-question&envId=2024-08-29

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int[] comps = new int[n];
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (comps[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (comps[cur] != 0) continue;
                comps[cur] = cnt;
                for (int dest : adj[cur]) {
                    if (comps[dest] == 0) q.add(dest);
                }
            }
            ++cnt;
        }
        // System.out.println(Arrays.toString(comps));
        return n - (--cnt);
    }
}