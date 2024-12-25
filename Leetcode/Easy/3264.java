// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/?envType=daily-question&envId=2024-12-16

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while(k --> 0) {
            int[] arr = pq.poll();
            pq.offer(new int[]{arr[0] * multiplier, arr[1]});
        }
        int[] ans = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            ans[arr[1]] = arr[0];
        }
        return ans;
    }

    public int[] better(int[] nums, int k, int multiplier) {
        // O(1) memory, and also faster than the PQ due to Java heapify speed
        for (int tmp = 0; tmp < k; ++tmp) {
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < nums[idx]) idx = i;
            }
            nums[idx] *= multiplier;
        }
        return nums;
    }
}