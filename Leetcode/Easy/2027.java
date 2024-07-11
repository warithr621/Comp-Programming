// https://leetcode.com/problems/minimum-moves-to-convert-string/description/


class Solution {
    public int minimumMoves(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == 'X') {
                ++ans;
                for (int j = i; j < i + 3 && j < s.length(); j++) arr[j] = '0';
            }
        }
        return ans;
    }
}