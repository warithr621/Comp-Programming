// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }
            d.offerLast(i);
        }
        // System.out.println(0 + " " + (k-1) + " " + d);
        ans[0] = nums[d.peekFirst()];

        for (int i = k; i < n; i++) {
            if (i - k == d.peekFirst()) {
                d.pollFirst();
            }
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }
            d.offerLast(i);
            // System.out.println((i - k + 1) + " " + i + " " + d);
            ans[i - k + 1] = nums[d.peekFirst()];
        }

        return ans;
    }
}