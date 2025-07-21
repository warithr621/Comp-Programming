// https://codeforces.com/contest/1085/problem/C

#include <bits/stdc++.h>
using namespace std;

int median(int a[3]) {
    int b[3];
    memcpy(b, a, sizeof(b));
    sort(b, b + 3);
    return b[1]; // this way we don't have to sort and preserve order
}

int main() {
    int x[3], y[3];
    for (int i = 0; i < 3; i++) cin >> x[i] >> y[i];
    
    // first, find median x and median y
    int xm = median(x), ym = median(y);
    
    // store all things in a set (avoid duplicate additions)
    set<pair<int, int>> ans;
    for (int i = 0; i < 3; i++) ans.insert({x[i], y[i]});
    
    // for each plot A B C, make a route to the median coordinates
    for (int i = 0; i < 3; i++) {
        while (x[i] != xm) {
            x[i] += (x[i] < xm ? 1 : -1);
            ans.insert({x[i], y[i]});
        }
        while (y[i] != ym) {
            y[i] += (y[i] < ym ? 1 : -1);
            ans.insert({x[i], y[i]});
        }
    }
    
    cout << ans.size() << '\n';
    for (auto p : ans) cout << p.first << ' ' << p.second << '\n';
}