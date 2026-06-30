// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/?envType=daily-question&envId=2026-06-28

class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] + 1 < arr[i]) {
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[n-1];
    }
};