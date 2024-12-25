// https://leetcode.com/problems/max-chunks-to-make-sorted/description/?envType=daily-question&envId=2024-12-19

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int ans = 0, pfx = 0, sortedpfx = 0;
        for (int i = 0; i < n; i++) {
            pfx += arr[i];
            sortedpfx += i;
            if (pfx == sortedpfx) ++ans;
        }
        return ans;
    }
}