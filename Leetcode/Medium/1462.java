// https://leetcode.com/problems/course-schedule-iv/description/?envType=daily-question&envId=2025-01-27

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // surely you could do some sort of DFS? maybe floyd
        boolean[][] ispre = new boolean[numCourses][numCourses];
        for (int[] e : prerequisites) {
            ispre[e[0]][e[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    // i -> j
                    ispre[i][j] = ispre[i][j] || (ispre[i][k] && ispre[k][j]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(ispre[q[0]][q[1]]);
        }
        return ans;
    }
}