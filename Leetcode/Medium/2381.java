// https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diff[shift[0]]++;
                if (shift[1] + 1 < n) diff[shift[1] + 1]--;
            } else {
                diff[shift[0]]--;
                if (shift[1] + 1 < n) diff[shift[1] + 1]++;
            }
        }
        StringBuilder ans = new StringBuilder(s);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = ((cnt + diff[i]) % 26 + 26) % 26;
            ans.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + cnt) % 26));
        }
        return ans.toString();
    }
}