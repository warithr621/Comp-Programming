// https://leetcode.com/problems/shuffle-an-array/

class Solution {

    int[] arr;
    int n;

    public Solution(int[] nums) {
        this.arr = nums;
        this.n = nums.length;
    }
    
    public int[] reset() {
        return arr;
    }
    
    public int[] shuffle() {
        // Fisher-Yates?
        int[] nxt = arr.clone();
        for (int i = n-1; i >= 1; i--) {
            // pick random j in [0,i] to swap
            int j = (new Random()).nextInt(i+1);
            int tmp = nxt[i];
            nxt[i] = nxt[j];
            nxt[j] = tmp;
        }
        return nxt;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */