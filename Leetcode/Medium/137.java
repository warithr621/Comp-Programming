// https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int x : nums) cnt += ((x & (1 << i)) == 0 ? 0 : 1);
            if (cnt % 3 == 1) ans |= (1 << i);
        }
        return ans;
    }
}