#include <bits/stdc++.h>
using namespace std;

int main() {
    int T; cin >> T;
    while (T--) {
        int N; cin >> N;
        int A[N], B[N];
        for (int &x : A) cin >> x;
        for (int &x : B) cin >> x;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (A[i] > B[i]);
        }
        cout << ans << '\n';
    }
}