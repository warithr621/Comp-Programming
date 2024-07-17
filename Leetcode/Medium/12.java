// https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;
class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] add = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            ans.append(add[i].repeat(num / vals[i]));
            num %= vals[i];
        }
        return ans.toString();
    }
}