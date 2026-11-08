// nick

#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    ll u; cin >> u;
    int N = 1e5;

    vector<bool> ip(N, true); ip[1] = 0;
    for (int i = 2; i < N; i++) {
        if (ip[i]) {
            for (int j = i + i; j < N; j+= i)
                ip[j] = false;
        }
    }
    
    vector<ll> cur;
    for (int i = 2; i < N; i++) {
        if (!ip[i])
            continue;
        while (u % i == 0) {
            u /= i;
            cur.push_back(i);
        }
    }

    if (u != 1)
        cur.push_back(u);
    sort(cur.rbegin(), cur.rend());

    ll res = 1, rn = 1;
    for (int i = 0; i < cur.size() - 1; i++) {
        rn *= cur[i];
        res += rn;
    }
    cout << res;

    return 0;
}