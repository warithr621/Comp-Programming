// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/?envType=daily-question&envId=2024-10-11

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int target = times[targetFriend][0];
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        int next = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        TreeSet<Integer> avail = new TreeSet<>();
        for (int[] t : times) {
            int arrive = t[0], leave = t[1];
            while (!pq.isEmpty() && pq.peek()[0] <= arrive)
                avail.add(pq.poll()[1]);
                int cur = -1;
                if (!avail.isEmpty()) {
                    cur = avail.first();
                    avail.remove(cur);
                } else cur = next++;
            pq.offer(new int[]{leave, cur});
            if (arrive == target) return cur;
        }
        return 0;
    }
}