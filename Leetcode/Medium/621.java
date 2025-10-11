// https://leetcode.com/problems/task-scheduler/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // simulation?
        int[] f = new int[26];
        for (char c : tasks) f[c - 'A']++;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) pq.offer(f[i]);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int cycle = n+1;
            List<Integer> cur = new ArrayList<>();
            int cnt = 0;
            while (cycle-- > 0 && !pq.isEmpty()) {
                int tmp = pq.poll();
                if (tmp > 1) cur.add(tmp - 1);
                ++cnt;
            }
            cur.forEach(pq::offer);
            ans += (pq.isEmpty() ? cnt : n+1);
        }
        return ans;
    }
}