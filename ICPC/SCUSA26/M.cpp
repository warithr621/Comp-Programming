// nick

#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    int n; cin >> n;
    unordered_map<int, unordered_map<int, vector<int>>> mp;
    vector<pair<int, int>> c(n);

    for (int i = 0; i < n; i++) {
        int u, v; cin >> u >> v;
        u /= 1000;
        v /= 1000;
        mp[u][v].push_back(i);
        c[i] = {u, v};
    }

    for (int i = 0; i < n; i++) {
        auto [u, v] = c[i];
        if (mp[u][v].size() > 1)
            continue;
        bool bad = false;
        for (int l = -1; l < 2; l++) {
            for (int r = -1; r < 2; r++) {
                if (l == 0 && r == 0)
                    continue;
                if (!mp[u + l][v + r].empty())
                    bad = true;
            }
        }
        if (!bad) {
            cout << mp[u][v].back() + 1;
            return 0;
        }
    }


    return 0;
}