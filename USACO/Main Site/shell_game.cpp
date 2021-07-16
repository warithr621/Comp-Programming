//Problem: 2019 January Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=891

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("shell.in", "r", stdin);
    freopen("shell.out", "w", stdout);
    int n; cin >> n;
    int cur[] = {1, 2, 3};
    int ans[] = {0, 0, 0};
    while(n-->0) {
        int x, y, z; cin >> x >> y >> z;
        swap(cur[--x], cur[--y]);
        ans[cur[--z] - 1]++;
    }
    cout << *max_element(ans, ans + 3);
}
