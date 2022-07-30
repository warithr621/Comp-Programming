// CSES Subordinates

#include <bits/stdc++.h>
using namespace std;

vector<int> children[200005];
int sz[200005];

void dfs(int x) {
    sz[x] = 1;
    for (int i : children[x]) {
        dfs(i);
        sz[x] += sz[i];
    }
}

int main() {
    int n; cin >> n;
    for (int i = 0; i < n-1; i++) {
        int a; cin >> a;
        children[a-1].push_back(i+1);
    }
    dfs(0);
    for (int i = 0; i < n; i++) cout << --sz[i] << ' ';
}
