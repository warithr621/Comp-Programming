// Problem: https://codeforces.com/contest/1986/problem/D

#include <bits/stdc++.h>
using namespace std;

int main() {
    int T; cin >> T;
    while(T--) {
        int N; cin >> N;
        string S; cin >> S;
        if (N <= 2) {
            cout << stoi(S) << '\n';
            continue;
        }
        string thonk[N-1];
        thonk[0] = S.substr(0, 2);
        for (int i = 1; i < N-1; i++) thonk[i] = S[i+1];
        int ans = (int) 1e9;
        for (int i = 0; i < N-1; i++) {
            // for (string str : thonk) cout << str << ' ';
            // cout << "clown\n";
            // cout << flush;
            bool z = false, o = true;
            for (string str : thonk) {
                z |= (stoi(str) == 0);
                o &= (stoi(str) == 1);
            }
            if (z) {
                ans = 0;
                // cout << "z\n";
            } else if (o) {
                ans = min(ans, 1);
                // cout << "o\n";
            } else {
                int cur = 0;
                for (string str : thonk) {
                    if (stoi(str) != 1) cur += stoi(str);
                }
                // cout << cur << "e\n";
                ans = min(ans, cur);
            }
            // cout << "done\n" << flush;
            if (i != N-2) {
                // cout << thonk[i] << ' ' << thonk[i+1] << "c\n" << flush;
                thonk[i+1] = thonk[i][1] + thonk[i+1];
                // cout << thonk[i] << ' ' << thonk[i+1] << "c\n" << flush;
                thonk[i] = thonk[i].substr(0,1);
                // cout << thonk[i] << ' ' << thonk[i+1] << "c\n" << flush;
            }
        }
        cout << ans << '\n';
    }
}