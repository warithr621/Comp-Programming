// https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2024-11-01

class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;
        StringBuilder ans = new StringBuilder(s.substring(0,2));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != ans.charAt(ans.length()-1) ||
                s.charAt(i) != ans.charAt(ans.length()-2)) {
                    ans.append(s.charAt(i));
                }
        }
        return ans.toString();
    }
}