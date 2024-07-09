// https://leetcode.com/problems/squares-of-a-sorted-array/description/

class Solution {
    public int[] sortedSquares(int[] nums) {
        // easy O(N log N) solution
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<>();
        for (int x : nums) al.add(x * x);
        Collections.sort(al);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = al.get(i);
        return ans;
    }

    public int[] fast(int[] nums) {
    	// fun O(N) solution
    	int n = nums.length;
        int ptr = 0;
        while (ptr + 1 < n && nums[ptr+1] <= 0) ++ptr;
        // now our ptr should either be on the latest zero, or on the biggest negative element
        int L = ptr, R = ++ptr, idx = 0;
        int[] ans = new int[n];
        while (idx < n) {
            // see if we should add the Lth element or the Rth element
            // remember to do out of bounds checks
            if (L < 0) {
                // must add R
                ans[idx++] = nums[R] * nums[R];
                ++R;
            } else if (R >= n) {
                // must add L
                ans[idx++] = nums[L] * nums[L];
                --L;
            } else {
                // use actual logic
                if (Math.abs(nums[L]) < Math.abs(nums[R])) {
                    ans[idx++] = nums[L] * nums[L];
                    --L;
                } else {
                    ans[idx++] = nums[R] * nums[R];
                    ++R;
                }
            }
        }
        return ans;
    }
}