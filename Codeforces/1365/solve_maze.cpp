// https://codeforces.com/contest/1365/problem/D

#include <bits/stdc++.h>
using namespace std;

int T, N, M;
int dx[] = {1, 0, -1, 0}, dy[] = {0, -1, 0, 1};
char A[60][60];
vector< pair<int,int> > good, bad;
bool vis[60][60];

void flood(int x, int y) {
    vis[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (A[nx][ny] == '#' || vis[nx][ny]) continue;
        flood(nx, ny);
    }
}

string solve() {
    good.clear(); bad.clear();
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> A[i][j];
            if (A[i][j] == 'G') good.push_back({i, j});
            if (A[i][j] == 'B') bad.push_back({i, j});
        }
    }
    
    // first check if the condition is already satisfied?
    memset(vis, false, sizeof(vis));
    flood(N-1, M-1);
    bool yay = true;
    for (auto p : good) yay &= vis[p.first][p.second];
    for (auto p : bad) if (vis[p.first][p.second]) yay = false;
    if (yay) return "Yes";
    
    // next idea: fence in bad people bcz they suck
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (A[i][j] == 'B') {
                // make sure in bounds + we can put fence
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (A[nx][ny] == '.' ) A[nx][ny] = '#';
                }
            }
        }
    }
    
    //redo the flood
    memset(vis, false, sizeof(vis));
    if (A[N-1][M-1] != '#') flood(N-1, M-1);
    bool yee = true;
    for (auto p : good) yee &= vis[p.first][p.second];
    for (auto p : bad) if (vis[p.first][p.second]) yee = false;
    if (yee) return "Yes";
    
    return "No";
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> T;
    while(T--) cout << solve() << '\n';
}