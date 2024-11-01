// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/?envType=daily-question&envId=2024-10-12

class Solution {
    public int minGroups(int[][] intervals) {
        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] arr : intervals) {
            if (!pq.isEmpty() && pq.peek() < arr[0]) pq.poll();
            pq.add(arr[1]);
        }
        return pq.size();
    }
}