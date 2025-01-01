// https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/description/

#define max(x, y) (((x) > (y)) ? (x) : (y))

int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int maxDistinctElements(int* nums, int numsSize, int k) {
    qsort(nums, numsSize, sizeof(int), compare);
    int ans = 0, last = INT_MIN;
    for (int i = 0; i < numsSize; i++) {
        int mn = nums[i] - k, mx = nums[i] + k;
        if (last < mn) {
            last = mn;
            ans++;
        } else if (last < mx) {
            last++;
            ans++;
        }
    }
    return ans;
}