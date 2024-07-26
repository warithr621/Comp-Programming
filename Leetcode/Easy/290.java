// https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] match = new String[26];
        String[] spl = s.split(" ");
        HashSet<String> used = new HashSet<>();
        if (pattern.length() != spl.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (match[c - 'a'] == null) {
                if (used.contains(spl[i])) return false;
                used.add(spl[i]);
                match[c - 'a'] = spl[i];
            }
            else {
                if (!match[c - 'a'].equals(spl[i])) return false;
            }
        }
        return true;
    }
}