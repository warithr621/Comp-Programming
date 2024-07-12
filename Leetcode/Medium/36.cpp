// https://leetcode.com/problems/valid-sudoku/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            set<char> row, col;
            int dr = 0, dc = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') ++dr;
                if (board[j][i] == '.') ++dc;
                row.insert(board[i][j]);
                col.insert(board[j][i]);
            }
            // cout << row.size() << ' ' << col.size() << '\n';
            if (row.size() != 9 - dr + 1 || col.size() != 9 - dc + 1) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set<char> s;
                int dot = 0;
                for (int m = i; m < i+3; m++) {
                    for (int n = j; n < j+3; n++) {
                        if (board[m][n] == '.') ++dot;
                        s.insert(board[m][n]);
                    }
                }
                if (s.size() != 9 - dot + 1) return false;
            }
        }
        return true;
    }
};