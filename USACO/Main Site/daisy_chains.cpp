//Problem: 2020 December Bronze P2 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=1060

#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    int ans = n;
    for (int i = 2; i <= n; i++) {
        for(int j = 0; j <= n-i; j++) {
            int sum = 0;
            for (int k = j; k < j+i; k++) sum += a[k];
            int avg = (sum % i == 0 ? sum / i : -1);
            for (int k = j; k < j+i; k++) {
                if (a[k] == avg) {
                    ++ans;
                    break;
                }
            }
        }
    }
    cout << ans << '\n';
}
