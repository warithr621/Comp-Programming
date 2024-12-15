// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/?envType=daily-question&envId=2024-12-10

class Solution {
    public int maximumLength(String s) {
        for (int len = s.length() - 2; len >= 1; len--) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String sub = s.substring(i, i + len);
                boolean special = true;
                for (int j = 1; j < sub.length(); j++) {
                    special &= (sub.charAt(0) == sub.charAt(j));
                }
                if (!special) continue;
                // System.out.println(sub);
                int cnt = 0;
                for (int j = i + 1; j < s.length() - len + 1; j++) {
                    if (s.substring(j, j + len).equals(sub)) ++cnt;
                }
                if (cnt == 2) return len;
            }
        }
        return -1;
    }
}