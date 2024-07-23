// https://leetcode.com/problems/intersection-of-two-arrays-ii/?envType=daily-question&envId=2024-07-02

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> ans;
        int n = nums1.size(), m = nums2.size();
        int L = 0, R = 0;
        while (L < n && R < m) {
            if (nums1[L] == nums2[R]) {
                ans.push_back(nums1[L]);
                ++L; ++R;
            } else if (nums1[L] > nums2[R]) ++R;
            else ++L;
        }
        return ans;
    }
};