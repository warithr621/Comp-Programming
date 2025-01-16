// https://leetcode.com/problems/construct-k-palindrome-strings/?envType=daily-question&envId=2025-01-11

bool canConstruct(char* s, int k) {
    // WOW c is a very weird language
    // ignore the fact this is like terrible language usage
    int* n = (int*) malloc(sizeof(int)); *n = strlen(s);
    if (*n <= k) {
        bool ans = (*n == k);
        free(n);
        return ans;
    }
    bool* freq = (bool*) calloc(26, sizeof(bool));
    for (int i = 0; i < *n; i++) {
        freq[s[i] - 'a'] ^= 1;
    }
    free(n);
    int* odd = (int*) malloc(sizeof(int)); *odd = 0;
    for (int i = 0; i < 26; i++) *odd += freq[i];
    bool ans = (*odd <= k);
    free(freq);
    free(odd);
    return ans;
}

bool alt(char* s, int k) {
    // this is more real-person code i think (bcz technically you shouldn't malloc everything LOL)
    int n = strlen(s);
    if (n <= k) return (n == k);
    bool* freq = (bool*) calloc(26, sizeof(bool));
    for (int i = 0; i < n; i++) {
        freq[s[i] - 'a'] ^= 1;
    }
    int odd = 0;
    for (int i = 0; i < 26; i++) odd += freq[i];
    free(freq);
    return (odd <= k);
}