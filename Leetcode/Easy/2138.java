// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/?envType=daily-question&envId=2025-06-22

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (n + k - 1) / k;
        String[] ans = new String[m];
        for (int i = 0, j = 0; i < m; i++, j += k) {
            String t = s.substring(j, Math.min(j+k, n));
            if (t.length() != k) t = t + ("" + fill).repeat(k - t.length());
            ans[i] = t;
        }
        return ans;
    }
}