// https://leetcode.com/problems/parallel-courses-iii/

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] prereqs = new int[n+1];
        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            next.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            prereqs[r[1]]++;
            next.get(r[0]).add(r[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] finish = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (prereqs[i] == 0) {
                q.add(i);
                finish[i] = time[i-1];
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            ans = Math.max(ans, finish[course]);
            for (int nxt : next.get(course)) {
                finish[nxt] = Math.max(
                    finish[nxt],
                    finish[course] + time[nxt-1]
                );
                prereqs[nxt]--;
                if (prereqs[nxt] == 0) q.add(nxt);
            }
        }

        return ans;
    }
}