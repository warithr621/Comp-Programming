// CSES Monsters

#include <bits/stdc++.h>
using namespace std;
#define pii pair<int, int>

int N, M;
queue<pii> q;
int dist[1005][1005];
pii from[1005][1005];
int inf = (int) 1e8;
pii start;
string ans;
bool works = false, alpha = false;

void bound(pii cur, pii dest) {
    // can we even get here?
    int d = dist[cur.first][cur.second];
    if (d + 1 < dist[dest.first][dest.second]) {
        // we found a quicker way to get to dest
        dist[dest.first][dest.second] = ++d;
        q.push(dest);
        from[dest.first][dest.second] = cur; // stores the most recent node
    }
}

void path(pii cur) {
    pii old = from[cur.first][cur.second];
    if (old == pii{0, 0}) return;
    if (old.first == cur.first) ans.push_back(old.second < cur.second ? 'R' : 'L');
    else ans.push_back(old.first < cur.first ? 'D' : 'U');
    path(old);
}

void bfs() {
    while (!q.empty()) {
        pii cur = q.front(); q.pop();
        int x = cur.first, y = cur.second;
        // check all adjacent locations
        bound(cur, {x, y+1}); bound(cur, {x, y-1});
        bound(cur, {x+1, y}); bound(cur, {x-1, y});
        if (alpha && (x == 1 || y == 1 || x == N || y == M)) {
            // YOOO WE ESCAPED
            cout << "YES\n";
            cout << dist[x][y] << '\n';
            path(cur);
            works = true;
            return;
        }
    }
}

int main() {
    cin >> N >> M;
    char grid[N][M];
    pii start;
    vector<pii> monsters;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            char ch; cin >> ch; // this is what the ch in eyangch stands for
            dist[i][j] = inf;
            if (ch == '#') dist[i][j] = 0;
            if (ch == 'M') {
                // add this to our BFS queue (we need to find min dist from cell to monster)
                q.push({i, j});
                dist[i][j] = 0;
            }
            if (ch == 'A') {
                start = {i, j};
            }
        }
    }
    
    bfs(); // monster distances
    alpha = true; // funny var so that bfs() will now run it for the person
    from[start.first][start.second] = {0, 0};
    dist[start.first][start.second] = 0;
    q.push(start); // init point
    bfs();
    if (works) {
        reverse(ans.begin(), ans.end());
        cout << ans << '\n';
    } else {
        cout << "NO" << '\n';
    }
}