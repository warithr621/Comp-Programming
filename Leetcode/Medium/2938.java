// https://leetcode.com/problems/separate-black-and-white-balls/?envType=daily-question&envId=2024-10-15

class Solution {
    public long minimumSteps(String s) {
        long cntZero = 0, sumZero = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                cntZero++;
                sumZero += i;
            }
        }
        cntZero = (cntZero - 1) * cntZero / 2;
        return sumZero - cntZero;
    }
}