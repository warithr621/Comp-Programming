// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                String s = words[i], t = words[j];
                if (s.length() > t.length()) continue;
                // s.length() <= t.length() is guaranteed
                int n = s.length(), m = t.length();
                ans += (s.equals(t.substring(0, n)) && s.equals(t.substring(m-n)) ? 1 : 0);
                /*
                lines 11 and 12 can be replaced with the following
                ans += (t.startsWith(s) && t.endsWith(s) ? 1 : 0);
                */
            }
        }
        return ans;
    }
}