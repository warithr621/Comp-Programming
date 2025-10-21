#include <bits/stdc++.h>
using namespace std;

struct State {
    int r, c, id, d;
};

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int R, C, n;
    cin >> R >> C >> n;

    const int INF = 1e9;
    int N = R * C;
    vector<int> best1_id(N, INF), best2_id(N, INF);
    vector<int> best1_d(N, INF), best2_d(N, INF);

    queue<State> q;
    for (int id = 1; id <= n; ++id) {
        int i, j; cin >> i >> j; --i; --j;
        int idx = i * C + j;
        if (0 < best1_d[idx] || (0 == best1_d[idx] && id < best1_id[idx])) {
            best2_d[idx] = best1_d[idx]; best2_id[idx] = best1_id[idx];
            best1_d[idx] = 0; best1_id[idx] = id;
        } else if (0 < best2_d[idx] || (0 == best2_d[idx] && id < best2_id[idx])) {
            best2_d[idx] = 0; best2_id[idx] = id;
        }
        q.push({i, j, id, 0});
    }

    const int dr[4] = {-1,1,0,0};
    const int dc[4] = {0,0,-1,1};

    while (!q.empty()) {
        State cur = q.front(); q.pop();
        int idx = cur.r * C + cur.c;
        bool valid = (best1_id[idx] == cur.id && best1_d[idx] == cur.d) || (best2_id[idx] == cur.id && best2_d[idx] == cur.d);
        if (!valid) continue;
        for (int k = 0; k < 4; ++k) {
            int nr = cur.r + dr[k], nc = cur.c + dc[k];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            int nidx = nr * C + nc;
            if (best1_id[nidx] == cur.id || best2_id[nidx] == cur.id) continue;
            int nd = cur.d + 1;
            bool inserted = false;
            if (nd < best1_d[nidx] || (nd == best1_d[nidx] && cur.id < best1_id[nidx])) {
                best2_d[nidx] = best1_d[nidx]; best2_id[nidx] = best1_id[nidx];
                best1_d[nidx] = nd; best1_id[nidx] = cur.id;
                inserted = true;
            } else if (nd < best2_d[nidx] || (nd == best2_d[nidx] && cur.id < best2_id[nidx])) {
                best2_d[nidx] = nd; best2_id[nidx] = cur.id;
                inserted = true;
            }
            if (inserted) q.push({nr, nc, cur.id, nd});
        }
    }

    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (j) cout << ' ';
            int idx = i * C + j;
            cout << best1_id[idx];
        }
        cout << '\n';
    }
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (j) cout << ' ';
            int idx = i * C + j;
            cout << best2_id[idx];
        }
        cout << '\n';
    }
    return 0;
}
