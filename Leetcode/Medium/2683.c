// https://leetcode.com/problems/neighboring-bitwise-xor/?envType=daily-question&envId=2025-01-17

bool doesValidArrayExist(int* derived, int derivedSize) {
    int ans = 0;
    for (int i = 0; i < derivedSize; i++) {
        ans ^= derived[i];
    }
    return ans == 0;
}