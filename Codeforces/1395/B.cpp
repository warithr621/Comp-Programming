//problem: https://codeforces.com/contest/1395/problem/B

#include <bits/stdc++.h>
using namespace std;

int n, m, sx, sy;

void f(int i, int j) {
    cout << (i + sx - 2) % n + 1 << ' ' << (j + sy - 2) % m + 1 << '\n';
}

int main() {
    cin >> n >> m >> sx >> sy;
    for (int i = 1; i <= n; i++) {
        if (i % 2 == 1) {
            for (int j = 1; j <= m; j++) f(i,j);
        } else {
            for (int j = m; j > 0; j--) f(i, j);
        }
    }
}
