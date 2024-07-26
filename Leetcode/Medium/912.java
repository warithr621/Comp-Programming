// https://leetcode.com/problems/sort-an-array/?envType=daily-question&envId=2024-07-25

class Solution {
    public int[] sortArray(int[] nums) {
        // counting sort:
        // O(sz) space, where MX is max(nums) - min(nums), so 1e5
        // O(N) time
        int[] cnt = new int[100005];
        for (int x : nums) cnt[x + 50000]++;
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < cnt.length; i++) {
            int x = cnt[i];
            while (x-- > 0) ans[idx++] = i - 50000;
        }
        return ans;
    }

    public void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] intended(int[] nums) {
        // heap sort:
        // O(1) space
        // O(N log N) time
        // the original Leetcode problem mentions to do this in N log N time
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = nums[i];
        for (int i = 1; i < n; i++) {
            if (ans[i] > ans[(i-1)/2]) {
                int j = i;
                while (ans[j] > ans[(j-1)/2]) {
                    // swap it down
                    swapper(ans, j, (j-1)/2);
                    j = (j-1)/2;
                }
            }
        }
        for (int i = n-1; i > 0; i--) {
            swapper(ans, 0, i);
            int j = 0, idx;
            do {
                idx = (j << 1) + 1;
                if (idx < i-1 && ans[idx] < ans[idx + 1]) ++idx;
                if (idx < i && ans[j] < ans[idx]) swapper(ans, j, idx);
                j = idx;
            } while (idx < i);
        }
        System.gc(); // apparently this kills memory usage LOL
        return ans;
    }
}