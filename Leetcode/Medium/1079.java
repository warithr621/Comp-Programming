// https://leetcode.com/problems/letter-tile-possibilities/description/?envType=daily-question&envId=2025-02-17

class Solution {

    private int recurse(int[] f) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (f[i] == 0) continue;
            ++ans;
            f[i]--;
            ans += recurse(f);
            f[i]++;
        }
        return ans;
    }

    public int numTilePossibilities(String tiles) {
        int[] f = new int[26];
        for (char c : tiles.toCharArray()) f[c - 'A']++;
        return recurse(f);
    }
}