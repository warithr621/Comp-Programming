// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/?envType=daily-question&envId=2024-10-09

class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0, needed = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++left;
            else if (left == 0) ++needed;
            else --left;
        }
        return left + needed;
    }
}