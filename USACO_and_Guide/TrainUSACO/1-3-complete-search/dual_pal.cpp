// USACO Trainer's "Dual Palindromes"

/*
ID: warithr1
LANG: C++11
TASK: dualpal
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
    freopen("dualpal.in", "r", stdin);
    freopen("dualpal.out", "w", stdout);

    int N,S; cin >> N >> S;
    for (int i = S+1; N != 0; ++i) {
        int cnt = 0;
        for (int base = 2; base <= 10; ++base) {
            if (pal(conv(i, base))) ++cnt;
        }
        if (cnt >= 2) {
            cout << i << '\n';
            --N;
        }
    }
}   