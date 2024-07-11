// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        sort(seats.begin(), seats.end());
        sort(students.begin(), students.end());
        int ans = 0;
        for (int i = 0; i < seats.size(); i++) {
            ans += (((seats[i] - students[i]) >> 31) ^ (seats[i] - students[i])) - ((seats[i] - students[i]) >> 31);
        }
        return ans;
    }
};