// https://leetcode.com/problems/adding-spaces-to-a-string/description/?envType=daily-question&envId=2024-12-03

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.substring(0, spaces[0]));
        for (int i = 0; i < spaces.length - 1; i++) {
            ans.append(' ').append(s.substring(spaces[i], spaces[i+1]));
        }
        ans.append(' ').append(s.substring(spaces[spaces.length-1]));
        return ans.toString();
    }
}