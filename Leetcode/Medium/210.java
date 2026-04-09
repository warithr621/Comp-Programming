// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // does there exist a top sort?
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : prerequisites) {
            adj.get(a[1]).add(a[0]);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int x : adj.get(i)) indegree[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            ans[idx++] = x;
            for (int y : adj.get(x)) {
                indegree[y]--;
                if (indegree[y] == 0) {
                    q.add(y);
                }
            }
        }
        if (idx == numCourses) return ans;
        else return new int[]{};
    }
}