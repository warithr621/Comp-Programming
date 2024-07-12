// https://leetcode.com/problems/search-a-2d-matrix/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size(), m = matrix[0].size();
        int L = 0, R = n * m - 1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (matrix[M/m][M%m] == target) return true;
            if (matrix[M/m][M%m] < target) L = ++M;
            else R = --M;
        }
        return false;
    }
};