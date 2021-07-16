//Problem: 2017 January Bronze P2 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=688

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    int n; cin >> n;
    int tc1 = 0, tc2 = 0;
    while(n--) {
        int x,y; cin >> x >> y;
        if (x == 1 && y == 2 || x == 2 && y == 3 || x == 3 && y == 1) ++tc1;
        if (x == 1 && y == 3 || x == 3 && y == 2 || x == 2 && y == 1) ++tc2;
    }
    cout << max(tc1, tc2);
}
