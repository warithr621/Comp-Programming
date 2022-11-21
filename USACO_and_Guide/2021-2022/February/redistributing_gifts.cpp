// 2022 Feb Silver P1

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <set>
using namespace std;

vector<vector<int>> graph;
int n;
bool reach[5000][5000];

void dfs(int start, int end) {
    //if you can get from i->j and j->k, then you can get from i->k
    if (reach[start][end]) return;
    reach[start][end] = true;
    for (int target : graph[end]) dfs(start, target);
}

int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    
    cin >> n;
    for (int i = 0; i <= n; i++) graph.push_back(vector<int>());

    for (int i = 1; i <= n; i++) {
        int temp[n];
        for (int j = 0; j < n; j++) cin >> temp[j];
        int counter = 0;
        while(temp[counter] != i) {
            graph[i].push_back(temp[counter]);
            ++counter;
        }
        graph[i].push_back(i);
    }

    for (int i = 1; i <= n; i++) dfs(i, i);

    for (int i = 1; i <= n; i++) {
        for (int j : graph[i]) {
            if (reach[j][i]) {
                cout << j << '\n';
                break;
            }
        }
    }
    // cout << '\n';
    // for (int i = 1; i <= n; i++) {
    //     for (int j : graph[i]) cout << j << ' ';
    //         cout << '\n';
    // }
}
