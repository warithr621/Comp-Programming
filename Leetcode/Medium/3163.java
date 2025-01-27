// https://leetcode.com/problems/string-compression-iii/

class Solution {
    public String compressedString(String word) {
        int cnt = 0;
        char cur = word.charAt(0);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == cur && cnt < 9) ++cnt;
            else {
                ans.append(cnt).append(cur);
                cnt = 1;
                cur = word.charAt(i);
            }
        }
        ans.append(cnt).append(cur);
        return ans.toString();
    }
}