// CSES Two Sets

#include <bits/stdc++.h>
using namespace std;
 
int main() {
    int n; cin >> n;
    if (n % 4 == 0) {
        cout << "YES\n";
        cout << n/2 << '\n';
        int L = n/4+1, R = 3 * n / 4;
        for (int i = 1; i <= n; i++) {
            if (L <= i && i <= R) continue;
            cout << i << ' ';
        }
        cout << "\n" << n/2 << '\n';
        for (int i = L; i <= R; i++) cout << i << ' ';
        cout << '\n';
    } else if (n % 4 == 3) {
        cout << "YES\n" << n/2+1 << '\n' << "1 2 ";
        for (int i = 4; i + 3 <= n; i += 4) cout << i << ' ' << i+3 << ' ';
        cout << '\n' << n/2 << '\n' << "3 ";
        for (int i = 5; i + 1 <= n; i += 4) cout << i << ' ' << i+1 << ' ';
        cout << '\n';
    } else cout << "NO\n";
}