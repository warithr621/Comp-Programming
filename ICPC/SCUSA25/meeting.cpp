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

void solve(){
    ll n, t, k; cin >> n >> t >> k;
    vector<pll> A(n);

    for (auto &[x, y] : A) cin >> x >> y;
    sort(A.begin(), A.end(), [&](auto x, auto y) { return x.second < y.second; });

    vector<ll> S, E;
    for (auto [x, y] : A) {
        S.push_back(x);
        E.push_back(y);
    }

    // for (ll x : S) cout << x << " ";


    vector<vector<ll>> dp(n + 1, vector<ll>(n + 1, 1e18));
    vector<vector<ll>> pm(n + 1, vector<ll>(n + 1, 1e18));

    ll res = 0;

    dp[0][0] = 0;
    pm[0][0] = 0;

    
    for (ll i = 1; i <= n; ++i) {
        dp[i][0] = 0;
        pm[i][0] = 0;
    }

    for (ll i = 1; i <= n; ++i) {
        for (ll j = 1; j <= i; ++j) {

            
            ll bef = upper_bound(E.begin(), E.end(), S[i - 1]) - E.begin();
            ll cost = E[i - 1] - S[i - 1];
            dp[i][j] = cost + pm[bef][j - 1];
            pm[i][j] = min(pm[i - 1][j], dp[i][j]);
            
            ll freeTime = t - dp[i][j];
            if (freeTime >= k) res = max(res, j);
        }
    }

    cout << res << endl;



}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    solve();
}