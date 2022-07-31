// CSES Nearest Smaller Values

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    stack<pair<int, int>> s;
    s.push({0, 0});
    for (int i = 1; i <= n; i++) {
        int x; cin >> x;
        while (!s.empty() && s.top().first >= x) s.pop();
        cout << s.top().second << ' ';
        s.push({x, i});
    }
}