// https://leetcode.com/problems/sort-the-jumbled-numbers/?envType=daily-question&envId=2024-07-24

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Conv[] pairs = new Conv[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Conv(nums[i], i, mapping);
        }
        Arrays.sort(pairs);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pairs[i].original;
        }
        return ans;
    }
}

class Conv implements Comparable<Conv> {
    int original, jumbled, index;
    public Conv(int x, int idx, int[] mapping) {
        this.original = x;
        this.index = idx;
        int temp = x, place = 1;
        jumbled = 0;
        if (temp == 0) {
            // edge case where the original number is just "0"
            jumbled = mapping[0];
            return;
        }
        while (temp != 0) {
            jumbled += place * mapping[temp % 10];
            temp /= 10;
            place *= 10;
        }
    }
    public int compareTo(Conv c) {
        if (this.jumbled != c.jumbled) {
            return this.jumbled - c.jumbled;
        }
        return this.index - c.index;
    }
}