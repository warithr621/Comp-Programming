// 2016 Jan Silver P2

#include <bits/stdc++.h>
using namespace std;

char beats(char x) {
    if (x == 'H') return 'S';
    if (x == 'S') return 'P';
    if (x == 'P') return 'H';
    return 'a';
}

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    // h -> s -> p -> h -> ...
    int n; cin >> n;
    char inp[n];
    char op[] = {'H', 'P', 'S'};
    for (int i = 0; i < n; i++) cin >> inp[i];
    vector<int> h(n+1, 0), p(n+1, 0), s(n+1, 0);
    for (int i = 1; i <= n; i++) {
        h[i] = h[i-1] + (inp[i-1] == 'H');
        p[i] = p[i-1] + (inp[i-1] == 'P');
        s[i] = s[i-1] + (inp[i-1] == 'S');
    }
    // for (int i = 0; i <= n; i++) {
    //     cout << h[i] << ' ' << p[i] << ' ' << s[i] << "   " << i <<  '\n';
    // }
    int ans = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                int x;
                if (beats(op[i]) == 'H') x = h[n];
                else if (beats(op[i]) == 'P') x = p[n];
                else x = s[n];
                ans = max(x, ans);
                // int x = (beats(op[i]) == 'H' ? h[n] : (beats(op[i]) == 'P' : p[n] : s[n]));
            } else {
                for (int sw = 1; sw < n; ++sw) {
                    int x = 0;
                    if (beats(op[i]) == 'H') x += h[sw];
                    else if (beats(op[i]) == 'P') x += p[sw];
                    else x += s[sw];
                    
                    if (beats(op[j]) == 'H') x += h[n] - h[sw];
                    else if (beats(op[j]) == 'P') x += p[n] - p[sw];
                    else x += s[n] - s[sw];
                    
                    ans = max(x, ans);
                }
            }
        }
    }
    cout << ans << '\n';
}