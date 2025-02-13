// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findArray(int* pref, int prefSize, int* returnSize) {
    for (int i = prefSize - 1; i > 0; i--){
        pref[i] ^= pref[i-1];
    }
    *returnSize=prefSize;
    return pref;
}