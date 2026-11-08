// edward

#include <bits/stdc++.h>

using namespace std;

struct Plug {
    int p;
    int a;
    int b;
};

typedef long long ll;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    int d, t, w, n;
    cin >> d >> t >> w >> n;

    vector<Plug> plugs;
    for (int i = 0; i < n; i++) {
        Plug p;
        cin >> p.p >> p.a >> p.b;
        plugs.push_back(p);
    }

    sort(plugs.begin(), plugs.end(), [](const Plug& a, const Plug& b) {
        return a.b > b.b;
    });

    vector<vector<vector<ll>>> dp(501, vector<vector<ll>>(501, vector<ll>(501, LONG_LONG_MAX)));

    for (int i = 0; i <= w; i++) {
        dp[0][i][0] = 0;
    }
    // dp[0][min(w,d)][0] = 0;
    for (int i = 0; i < n; i++) {
        Plug p = plugs[i];
        // cout << "PLUG: " << p.a << ' ' << p.b << ' ' << p.p << endl;
        for (int j = 0; j <= d; j++) {
            for (int k = 0; k <= d; k++) {
                dp[i + 1][j][k] = min(dp[i][j][k], dp[i + 1][j][k]);

                int nj = min(j + (p.b - 1), d);
                int nk = min(k + p.a, d);
                if (nj >= 0 && dp[i][j][k] < LONG_LONG_MAX) {
                    dp[i + 1][nj][nk] = min(dp[i + 1][nj][nk], dp[i][j][k] + p.p);
                }
            }
        }
    }

    ll ans = LONG_LONG_MAX;
    for (int j = 0; j <= d; j++) {
        for (int k = 0; k <= d; k++) {
            if (j >= t && j + k >= d) {
                ans = min(dp[n][j][k], ans);
            }
        }
    }
    cout << (ans == LONG_LONG_MAX ? -1 : ans) << endl;

    return 0;
}