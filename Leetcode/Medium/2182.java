// https://leetcode.com/problems/construct-string-with-repeat-limit/description/?envType=daily-question&envId=2024-12-17

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        char c = 'z';
        while (c >= 'a') {
            if (freq[c - 'a'] == 0) {
                --c;
                continue;
            }
            int amt = Math.min(freq[c - 'a'], repeatLimit);
            ans.append((""+c).repeat(amt));
            freq[c - 'a'] -= amt;
            if (freq[c - 'a'] > 0) {
                char next = (char) (c - 1);
                while (next >= 'a' && freq[next - 'a'] == 0) --next;
                if (next < 'a') break;
                ans.append(next);
                freq[next - 'a']--;
            }
        }
        return ans.toString();
    }
}