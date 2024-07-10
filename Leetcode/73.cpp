// https://leetcode.com/problems/set-matrix-zeroes/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
    	// O(NM) space
        int n = matrix.size();
        int m = matrix[0].size();
        cout << n << ' ' << m << '\n' << flush;
        vector< vector<bool> > change(n, vector<bool>(m, false));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) change[i][k] = true;
                    for (int k = 0; k < n; k++) change[k][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (change[i][j]) matrix[i][j] = 0;
            }
        }
    }

    void space(vector<vector<int>>& matrix) {
    	// O(N + M) space
        int n = matrix.size();
        int m = matrix[0].size();
        vector<bool> row(n, false), col(m, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

    void spacier(vector<vector<int>>& matrix) {
    	// O(1) space
        int n = matrix.size();
        int m = matrix[0].size();
        int mex = 1; // ok technically this might not be a mex
        // but trust the process
        do {
            bool fine = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) fine &= (matrix[i][j] != mex);
            }
            if (fine) break;
            ++mex;
        } while (true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) if (matrix[k][j] != 0) matrix[k][j] = mex;
                    for (int k = 0; k < m; k++) if (matrix[i][k] != 0) matrix[i][k] = mex;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == mex) matrix[i][j] = 0;
            }
        }
    }
};