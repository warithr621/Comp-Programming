// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // O(N log N)
        Queue<Integer> q = new PriorityQueue<>();
        for (int x : nums) q.add(x);
        for (int i = 0; i < nums.length - k; i++) q.poll();
        return q.poll();
    }

    public int faster(int[] nums, int k) {
        // O(N)
        int[] freq = new int[20005];
        for (int x : nums) freq[x + 10000]++;
        for (int i = freq.length - 1; i >= 0; i--) {
            while (freq[i] != 0) {
                --freq[i];
                --k;
                if (k == 0) return i - 10000;
            }
        }
        return -1337;
    }
}