// CSES Point Location Test

#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
    int x[3], y[3];
    for (int i = 0; i < 3; i++) cin >> x[i] >> y[i];
    
    // new idea: cross products???
    // let A be the displacement vector for P1 -> P2
    // and B be for P1 -> P3
    // the sign of A x B should determine the location of P3

    int A[] = {x[1] - x[0], y[1] - y[0]};
    int B[] = {x[2] - x[0], y[2] - y[0]};
    int prod = A[0] * B[1] - A[1] * B[0]; // magnitude of A x B
    if (prod == 0) cout << "TOUCH\n";
    else cout << (prod > 0 ? "LEFT" : "RIGHT") << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T --> 0) solve();
}