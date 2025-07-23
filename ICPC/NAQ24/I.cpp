/*
Im Nayeon
Yoo Jeongyeon
Momo Jjang
Sana Jjang
Park Jihyo
Mina Jjang
Kim Dahyun
Son Chaeyoung
Chou Tzuyu
One in a million
눈부시게 사랑해
트와이스 !!
*/

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)
%:define forn(i, n) for(int i = 0; i < n; ++i)

void solve() <%
    //code
    int N; cin >> N;
    char G[N][N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> G[i][j];
        }
    }
    vector< vector<bool> > vis(N, vector<bool>(N, false));
    queue<pii> q;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (G[i][j] == '?') {
                q.push({i, 80 * j});
            } else if ('0' <= G[i][j] && G[i][j] <= '4') {
                // right number of bulbs?
                // cout << i << "~" << j << '\n';
                vector<int> dx = {0, 1, 0, -1};
                vector<int> dy = {1, 0, -1, 0};
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x < 0 || x >= N || y < 0 || y >= N) continue;
                    if (G[x][y] == '?') {
                        // cout << x << y << '\n';
                        ++cnt;
                    }
                }
                if (cnt != (G[i][j] - '0')) {
                    // cout << i << ' ' << j << '\n';
                    //not right # of bulbs
                    cout << "0\n";
                    return;
                }
            }
        }
    }

    while (!q.empty()) {
        auto p = q.front(); q.pop();
        // if (vis[p.first][p.second/80]) continue;
        vis[p.first][p.second/80] = true;
        int dir = p.second % 80;
        // cout << p.first << ' ' << p.second/80 << ' ' << dir << '\n';
        vector<int> dx = {0, 1, 0, -1};
        vector<int> dy = {1, 0, -1, 0};
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int x = p.first + dx[k], y = p.second/80 + dy[k];
            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (G[x][y] == 'X' || ('0' <= G[x][y] && G[x][y] <= '4')) continue;
            if (dir == 0) {
                if (G[x][y] == '?') {
                    cout << "0\n";
                    return;
                }
                q.push({x, y * 80 + (k+1)});
            } else if (dir == k + 1) {
                if (G[x][y] == '?') {
                    cout << "0\n";
                    return;
                }
                q.push({x, y * 80 + dir});
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (G[i][j] == '.' && !vis[i][j]) {
                // cout << i << '~' << j << '\n';
                cout << "0\n";
                return;
            }
        }
    }
    cout << "1\n";
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
