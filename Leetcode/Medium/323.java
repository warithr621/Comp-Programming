// done through Neetcode:
// https://neetcode.io/problems/count-connected-components

class Solution {

    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] comps = new int[n];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            if (comps[i] == 0) {
                // hasn't been visited yet
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int src = q.poll();
                    if (comps[src] != 0) continue;
                    comps[src] = cur;
                    for (int x : adj[src]) {
                        if (comps[x] == 0) q.add(x);
                    }
                }
                cur++;
            }
        }
        return --cur;
    }
}
