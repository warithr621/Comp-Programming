// https://leetcode.com/problems/minimum-length-of-string-after-operations/?envType=daily-question&envId=2025-01-13

int minimumLength(char* s) {
    int freq[26];
    for (char c = *s; c != '\0'; c = *(++s)) {
        freq[c - 'a']++;
    }
    int ans = 0;
    for (int i = 0; i < 26; i++) {
        int x = freq[i];
        if (x != 0) {
            ans += ((x & 1) ? 1 : 2);
        }
    }
    return ans;
}