// https://leetcode.com/problems/adding-spaces-to-a-string/description/


class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ptr < spaces.length && i == spaces[ptr]) {
                ans.append(" " + s.charAt(i));
                ++ptr;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}