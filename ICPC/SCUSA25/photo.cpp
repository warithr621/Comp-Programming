#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int) (x).size()
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define vi vector<int>
#define vll vector<ll>

map<int, int> cnts;


bool check(int x) {
    for (auto [k, v] : cnts) {
        int avail = x - abs(x - (k + 1));
        // cout << avail << endl;
        if (avail < v) return false;
    }
    return true;
}

void solve(){
    int m; cin >> m;
    vi A(m);

    for (int &x : A) cin >> x;

    for (int x : A) ++cnts[x];

    int l = 0, r = 1000;

    while (l < r) {
        int mid = (l + r) / 2;

        if (check(mid)) r = mid;
        else l = mid + 1;
    }

    // cout << check(4) << endl;

    cout << r << endl;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    solve();
}