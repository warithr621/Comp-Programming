// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits == "") return vector<string>(0);
        vector<string> phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> ans = {""};
        for (int i = 0; i < digits.size(); i++) {
            vector<string> tmp;
            for (string str : ans) {
                for (char c : phone[digits[i] - '0']) {
                    tmp.push_back(str + c);
                }
            }
            ans = tmp;
        }
        return ans;
    }
};