// https://leetcode.com/problems/split-the-array/

import java.util.*;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] cont = new int[101];
        for (int x : nums) cont[x]++;
        boolean ans = true;
        for (int i = 1; ans && i <= 100; i++) ans &= cont[i] <= 2;
        return ans;
    }
}