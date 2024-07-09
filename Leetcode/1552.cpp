// https://leetcode.com/problems/magnetic-force-between-two-balls/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        // binary search yooooooo
        sort(position.begin(), position.end());
        int N = position.size();
        int L = 1, R = position[N-1] - position[0];
        // L and R are our pointers for the distance
        while (L < R) {
            int M = (L + R + 1) >> 1;
            // now see if we can pick at least 'm' cans that are at least M apart
            int cnt = 1; // left-most is fine
            int prev = position[0];
            for (int i = 1; i < N; i++) {
                if (position[i] - prev >= M) {
                    ++cnt;
                    prev = position[i];
                }
            }
            if (cnt >= m) L = M;
            else R = --M;
        }
        return L;
    }
};