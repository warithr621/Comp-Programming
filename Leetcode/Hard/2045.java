// https://leetcode.com/problems/second-minimum-time-to-reach-destination/?envType=daily-question&envId=2024-07-28

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] dist1 = new int[n+1], dist2 = new int[n+1], freq = new int[n+1];
        // dist1 is min time, dist2 is second-min time
        // freq is popping count
        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{1, 0});
        dist1[1] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int cur = temp[0];
            int time_taken = temp[1];
            freq[cur]++;

            if (freq[cur] == 2 && cur == n) return time_taken;
            if ((time_taken / change) % 2 == 1)
                time_taken = change * (time_taken / change + 1) + time;
            else
                time_taken = time_taken + time;

            if (!adj.containsKey(cur))
                continue;
            for (int dest : adj.get(cur)) {
                if (freq[dest] == 2) continue;

                if (dist1[dest] > time_taken) {
                    dist2[dest] = dist1[dest];
                    dist1[dest] = time_taken;
                    pq.offer(new int[]{dest, time_taken});
                } else if (dist2[dest] > time_taken && dist1[dest] != time_taken) {
                    dist2[dest] = time_taken;
                    pq.offer(new int[]{dest, time_taken});
                }
            }
        }
        return 0;
    }
}