// CSES Collecting Numbers

#include <bits/stdc++.h>
using namespace std;

int pos[200005];

int main() {
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        pos[x] = i; //'x' is located at index 'i'
    }
    
    int ans = 1;
    for (int i = 2; i <= n; i++) if (pos[i] < pos[i-1]) ++ans;
    cout << ans << '\n';
}