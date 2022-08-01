// CSES Common Divisors

#include <bits/stdc++.h>
using namespace std;

int freq[1000001];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        int a; cin >> a;
        for (int f = 1; f * f <= a; f++) {
            if (a % f == 0) {
                freq[f]++;
                if (f * f != a) ++freq[a / f];
            }
        }
    }
    
    int ans = 1000000;
    while (freq[ans] < 2) --ans;
    cout << ans << '\n';
}