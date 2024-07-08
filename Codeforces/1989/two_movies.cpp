// Problem: https://codeforces.com/contest/1989/problem/C

#include <bits/stdc++.h>
using namespace std;

int main() {
    int T; cin >> T;
    while(T--) {
        int N; cin >> N;
        int A[N], B[N];
        for (int &i : A) cin >> i;
        for (int &i : B) cin >> i;
        int f = 0, s = 0, p = 0, n = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > B[i]) f += A[i];
            else if (A[i] < B[i]) s += B[i];
            else if (A[i] == 1) ++p;
            else if (A[i] == -1) ++n;
        }
        int ans = -200005;
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= n; j++) {
                ans = max(ans, min(f + i - j, s + (p-i) - (n-j)));
            }
        }
        cout << ans << '\n';
    }
}