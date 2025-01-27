// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

#define MAX(x, y) (((x) > (y)) ? (x) : (y))

int maximumSum(int* nums, int numsSize) {
    // digit sum can be at most 81
    int* first = (int*) calloc(82, sizeof(int)); // biggest
    int* second = (int*) calloc(82, sizeof(int)); // second-biggest

    for (int i = 0; i < numsSize; i++) {
        int n = nums[i], digitSum = 0;
        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }
        if (nums[i] >= first[digitSum]) {
            second[digitSum] = first[digitSum];
            first[digitSum] = nums[i];
        } else if (nums[i] >= second[digitSum]) {
            second[digitSum] = nums[i];
        }
    }
    int ans = -1;
    for (int i = 1; i <= 81; i++) {
        if (second[i] == 0) {
            // we don't have two numbers
            continue;
        } else {
            ans = MAX(ans, first[i] + second[i]);
        }
    }

    free(first);
    free(second);
    return ans;
}