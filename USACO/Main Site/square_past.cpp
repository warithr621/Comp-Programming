//Problem: 2016 December Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=663

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("square.in", "r", stdin);
    freopen("square.out", "w", stdout);
    int ax1, ay1, ax2, ay2, bx1, by1, bx2, by2;
    cin >> ax1 >> ay1 >> ax2 >> ay2 >> bx1 >> by1 >> bx2 >> by2;
    int lex = min(ax1, bx1), ley = min(ay1, by1);
    int mex = max(ax2, bx2), mey = max(ay2, by2);
    int ans = max(mex-lex, mey-ley);
    cout << ans*ans << '\n';
}
