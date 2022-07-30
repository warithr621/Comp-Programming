// CSES Coin Piles

#include <bits/stdc++.h>
using namespace std;
 
void solve() {
    int a,b; cin >> a >> b;
    if (a < b) swap(a,b);
    if (a > 2*b) cout << "NO\n";
    else {
        a %= 3; b %= 3;
        if (a < b) swap(a,b);
        if (a == 2 && b ==1 || a == 0 && b == 0) cout << "YES\n";
        else cout << "NO\n";
    }
}
 
int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t; cin >> t;
    while(t--) solve();
}