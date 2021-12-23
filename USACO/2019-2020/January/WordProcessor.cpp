#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    freopen("word.in", "r", stdin);
    freopen("word.out", "w", stdout);
    
    int n,k; cin >> n >> k;
    int line = 0;
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        line += s.length();
        if (line > k) {
            cout << '\n' << s;
            line = s.length();
        } else if (i == 0) {
            cout << s;
        } else cout << ' ' << s;
    }
}
