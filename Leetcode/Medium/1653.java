// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30

class Solution {
    public int minimumDeletions(String s) {
        int N = s.length(), ans = N;
        int[] apfx = new int[N], bpfx = new int[N];
        for (int i = 1; i < N; i++) {
            bpfx[i] = bpfx[i-1] + (s.charAt(i-1) == 'b' ? 1 : 0);
        }
        for (int i = N-2; i >= 0; i--) {
            apfx[i] = apfx[i+1] + (s.charAt(i+1) == 'a' ? 1 : 0);
        }
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, apfx[i] + bpfx[i]);
        }
        return ans;
    }
}