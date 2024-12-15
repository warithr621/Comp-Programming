// https://leetcode.com/problems/maximum-average-pass-ratio/description/?envType=daily-question&envId=2024-12-15

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int[] arr : classes) {
            pq.offer(new double[]{ delta(arr[0], arr[1]), arr[0], arr[1] });
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] fix = pq.poll();
            pq.offer(new double[]{ delta(fix[1] + 1, fix[2] + 1), fix[1] + 1, fix[2] + 1});
        }
        double ratioSum = 0;
        while(!pq.isEmpty()) {
            double[] cur = pq.poll();
            ratioSum += (double) cur[1] / cur[2];
        }
        return ratioSum / classes.length;
    }
    public double delta(double x, double y) {
        return (x + 1) / (y + 1) - x / y;
    }
}