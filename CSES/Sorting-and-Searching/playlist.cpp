// CSES Playlist

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    int left = 0, right = -1, ans = 0;
    int k[n];
    for (int i = 0; i < n; i++) cin >> k[i];
    set<int> s;
    while(left < n) {
        while(right < n - 1 && !s.count(k[right+1])) s.insert(k[++right]);
        // cout << left << " " << right << "\n";
        ans = max(ans, right - left + 1);
        s.erase(k[left++]);
    }
    cout << ans << '\n';
}