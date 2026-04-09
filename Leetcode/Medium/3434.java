// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/description/

class Solution {

    public static int kadane(int[] arr) {
        int ans = arr[0], running = arr[0];
        for (int i = 1; i < arr.length; i++) {
            running = Math.max(running + arr[i], arr[i]);
            ans = Math.max(ans, running);
        }
        return ans;
    }

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        // find initial
        for (int x : nums) {
            if (x == k) ++start;
        }
        int ans = start;
        for (int modify = 1; modify <= 50; modify++) {
            if (modify == k) continue;
            // we will pick a value such that all "modify"s are turned into k
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (nums[i] == modify) arr[i] = 1;
                else if (nums[i] == k) arr[i] = -1;
                else arr[i] = 0;
            }
            ans = Math.max(ans, start + kadane(arr));
        }
        return ans;
    }

}