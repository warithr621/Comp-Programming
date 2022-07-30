#include <iostream>
// https://codeforces.com/contest/977/problem/F
// Virtual

#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    
    map<int, int> dp;
    //dp such that to update how many past elements work for it
    int sz = 0;
    int last = 0;
    for (int i = 0; i < n; i++) {
        int x = a[i];
        dp[x] = dp[x-1] + 1; //if say x = 3, then x=2 just got another working thing
        if (dp[x] > sz) {
            //x is an element in a, and dp[x] represents the size of the subseq ending in x
            sz = dp[x];
            last = x;
        }
    }
    cout << sz << '\n';
    vector<int> ans;
    //we have last element, so we have to move backwards
    for (int i = n-1; i >= 0; i--) {
        if (a[i] == last) {
            ans.push_back(i+1);
            --last;
        }
    }
    reverse(ans.begin(), ans.end());
    for (int i : ans) cout << i << ' ';
}