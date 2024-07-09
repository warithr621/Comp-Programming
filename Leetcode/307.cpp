// https://leetcode.com/problems/range-sum-query-mutable/description/

#include <bits/stdc++.h>
using namespace std;

class NumArray {
public:

    // wait this problem is literally sqrt decomp??

    int N, sz;
    vector<int> A;
    vector<int> sums;
    vector< pair<int,int> > ranges;

    NumArray(vector<int>& nums) {
        A.push_back(0); // I like 1-indexing
        for (int x : nums) A.push_back(x);
        N = nums.size();
        sz = (int) sqrt(N);
        for (int i = 0; i < sz; i++) {
            int cur = 0;
            for (int j = i * sz; j < i * sz + sz; j++) {
                cur += A[j+1];
            }
            sums.push_back(cur);
            ranges.push_back({i * sz + 1, sz * i + sz});
        }
        int cur = 0;
        for (int i = sz * sz + 1; i <= N; i++) {
            cur += A[i];
        }
        sums.push_back(cur);
        ranges.push_back({sz * sz + 1, N});
    }
    
    void update(int index, int val) {
        ++index;
        for (int i = 0; i < ranges.size(); i++) {
            auto p = ranges[i];
            if (p.first <= index && index <= p.second) {
                sums[i] += val - A[index];
                A[index] = val;
                break;
            }
        }
    }
    
    int sumRange(int left, int right) {
        left++; right++;
        int ans = 0;
        int L = 0, R = 0;
        while(ranges[L].first > left || left > ranges[L].second) ++L;
        while(ranges[R].first > right || right > ranges[R].second) ++R;
        if (L == R) {
            for (int i = left; i <= right; i++) ans += A[i];
        } else {
            for (int i = left; i <= ranges[L].second; i++) ans += A[i];
            for (int i = ranges[R].first; i <= right; i++) ans += A[i];
            for (int i = L+1; i < R; i++) ans += sums[i];
        }
        return ans;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */