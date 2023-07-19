// https://codeforces.com/contest/85/problem/A

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; cin >> N;
    if (N == 1) {
        cout << "a\na\nb\nb";
        return 0;
    } else if (N == 2) {
        cout << "aa\nbb\ncc\ndd\n";
        return 0;
    } // edge cases lol
    
    if (N % 2 == 1) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1 and i < 2) cout << "e";
                else if (j == N and i > 1) cout << "f";
                else if (i < 2) {
                    if (j % 4 > 1) cout << (i == 0 ? "b" : "c");
                    else cout << (i == 0 ? "a" : "d");
                } else {
                    if (j % 4 == 1 or j % 4 == 2) cout << (i == 2 ? "b" : "c");
                    else cout << (i == 2 ? "a" : "d");
                }
            }
            cout << '\n';
        }
    } else {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= N; j++) {
                if (i < 2) {
                    if (j == 1) cout << "e";
                    else if (j == N) cout << "f";
                    else if (j % 4 > 1) cout << (i == 0 ? "b" : "c");
                    else cout << (i == 0 ? "a" : "d");
                } else {
                    if (j % 4 == 1 or j % 4 == 2) cout << (i == 2 ? "b" : "c");
                    else cout << (i == 2 ? "a" : "d");
                }
            }
            cout << '\n';
        }
    }
}