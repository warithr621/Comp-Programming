// https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01

bool isArraySpecial(int* nums, int numsSize) {
    for (int i = 0; i + 1 < numsSize; i++) {
        if ((nums[i] % 2 == 1) ^ (nums[i+1] % 2 == 1) == 0) return false;
    }
    return true;
}