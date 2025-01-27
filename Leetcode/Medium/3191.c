// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/

int minOperations(int* nums, int numsSize) {
    int flips = 0;
    for (int i = 0; i + 2 < numsSize; i++) {
        if (nums[i] == 0) {
            for (int j = i; j <= i+2; j++) {
                nums[j] ^= 1;
            }
            ++flips;
        }
    }
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 0) return -1;
    }
    return flips;
}