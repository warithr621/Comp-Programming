// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        String cur = "";
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (cur.length() == 0) cur = haystack.substring(0, needle.length());
            else cur = cur.substring(1) + haystack.charAt(i + needle.length() - 1);
            if (cur.equals(needle)) return i;
        }
        return -1;
    }
}