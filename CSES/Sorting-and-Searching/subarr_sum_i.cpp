// CSES Subarray Sums I

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n,x; cin >> n >> x;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    int ans = 0;
    int left = 0, right = 0, sum = a[0];
    while(left < n && right < n) {
        while(right+1 < n && sum + a[right+1] <= x) sum += a[++right];
        // cout << left << ' ' << right << ' ' << sum <<  '\n';
        if (sum == x) ++ans;
        sum -= a[left++];
    }
    cout << ans << '\n';
}
