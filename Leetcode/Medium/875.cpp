// https://leetcode.com/problems/koko-eating-bananas/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int L = 1, R = (int) (1e9) + 1;
        while (L < R) {
            int M = (L + R) >> 1;
            int cnt = 0;
            for (int x : piles) cnt += (x + M - 1) / M;
            if (cnt <= h) R = M;
            else L = ++M;
        }
        return L;
    }
};