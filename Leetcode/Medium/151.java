// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int R = s.length() - 1, L = s.length() - 1;
        while (R >= 0) {
            while (R >= 0 && s.charAt(R) == ' ') --R;
            if (R < 0) break;
            L = R - 1;
            while (L >= 0 && s.charAt(L) != ' ') --L;
            ans.append(s.substring(L+1, R+1));
            ans.append(' ');
            R = L - 1;
        }
        ans.setLength(ans.length() - 1); // cut off trailing space
        return ans.toString();
    }
}