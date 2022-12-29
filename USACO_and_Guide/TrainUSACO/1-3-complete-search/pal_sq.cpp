// USACO Trainer's "Palindromic Squares"

/*
ID: warithr1
LANG: C++11
TASK: palsquare
*/

#include <bits/stdc++.h>
using namespace std;

string conv(int x, int base) {
    // convert 'x' to new base
    string ans = "";
    while(x > 0) {
        int dig = x % base;
        if (dig <= 9) ans += (char) ('0' + dig);
        else ans += (char) ('A' + dig - 10);
        x /= base;
    }

    reverse(ans.begin(), ans.end());
    return ans;
}

bool pal(string s) {
    for (int i = 0; i <= s.length() / 2; i++) {
        if (s[i] != s[s.length() - i - 1]) return false;
    }
    return true;
}

int main() {
    freopen("palsquare.in", "r", stdin);
    freopen("palsquare.out", "w", stdout);

    int B; cin >> B;
    for (int i = 1; i <= 300; i++) {
        string ob = conv(i, B), sb = conv(i*i, B);
        // cout << "CONV " << i << ' ' << ob << '\n';
        if (pal(sb)) {
            cout << ob << ' ' << sb << '\n';
        }
    }
}   