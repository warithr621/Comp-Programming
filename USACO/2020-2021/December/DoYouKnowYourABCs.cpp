#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    vector<int> a(7);
    for (int i = 0; i < 7; i++) cin >> a[i];
    sort(a.begin(), a.end());
    cout << a[0] << ' ' << a[1] << ' ' << a[6] - a[1] - a[0] << '\n';
}
