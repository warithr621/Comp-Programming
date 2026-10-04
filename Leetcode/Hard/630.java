// https://leetcode.com/problems/course-schedule-iii/

class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a,b) -> a[1] - b[1]); // sort by end date
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            q.add(c[0]);
            if (time > c[1]) {
                time -= q.poll();
            }
            // System.out.println(q);
        }
        return q.size();
    }
}