// https://leetcode.com/problems/bitwise-xor-of-all-pairings/?envType=daily-question&envId=2025-01-16

int xorAllNums(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int ans = 0;
    if (nums1Size & 1) {
        for (int i = 0; i < nums2Size; i++) {
            ans ^= nums2[i];
        }
    }
    if (nums2Size & 1) {
        for (int i = 0; i < nums1Size; i++) {
            ans ^= nums1[i];
        }
    }
    return ans;
}