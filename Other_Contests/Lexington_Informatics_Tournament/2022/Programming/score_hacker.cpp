//Source: 2022 Lexington Informatics Tournament Standard Round C (Score Hacker)

#include <bits/stdc++.h>

using namespace std;

using ll = long long;

// ll bs(ll a, ll b, ll d, bool c, ll part) {
//     ll lo = 0, hi = d;
//     while (lo < hi) {
//         ll x = (lo + hi) / 2;
//         if (x + (x*a-1)/b+1 <= d) {
//             lo = x;
//         } else {
//             hi = x-1;
//         }
//     }
//     return lo;
// }

int main() {
    ll n,k; cin>>n>>k;
    k /= 2;
    vector<ll> as(n);
    for (auto& a : as) {
        cin >> a;
    }
    sort(as.begin(),as.end());
    ll m = (n-1)/2;
    ll low = 0;
    for (ll i = 0; i < m; ++i) {
        low += as[i];
    }
    bool b = k <= low;
    low = min(low,k);
    k -= low;
    ll i = m+1;
    for (; i < n; ++i) {
        ll next = (i-m)*(as[i]-as[i-1]);
        if (low <= next) {
            if (b) {
                cout << as[i-1] + low/(i-m);
                return 0;
            }
            goto next;
        }
        low -= next;
    }
    cout << as[n-1] + low/(n-m);
    return 0;
    next:;
    // k is budget, low is part
    ll lo = as[i-1], hi = as[n-1]+low;
    while (lo < hi) {
        ll x = (lo + hi + 1)/2;
        ll j = i;
        ll up = 0;
        for (; j < n && as[j] <= x; ++j) {
            up += (j-m)*(as[j]-as[j-1]);
        }
        up += (j-m)*(x-as[j-1]);
        up -= low;
        if (up < 0) {
            lo = x+1;
            continue;
        }
        if (up > k) {
            hi = x-1;
            continue;
        }
        ll down = 0;
        j = n-1;
        for (; as[k-1] >= x; --j) {
            down += (n-k)*(as[j]-as[j-1]);
        }
        down += (n-j)*(as[j]-x);
        if (down < up) {
            hi = x-1;
            continue;
        } else {
            lo = x;
            continue;
        }
    }
    cout << lo;
    // ll j = n-1;
    // ll up = (i-m)*(as[i]-as[i-1]);
    // ll down = (n-j)*(as[j]-as[j-1]);
    // ll part = 0;
    // while (i+1 < j) {
    //     if (up <= down) {
    //         ++i;
    //         down -= up;
    //         up = (i-m)*(as[i]-as[i-1]);
    //         part = 0;
    //     } else {
    //         --j;
    //         up -= down;
    //         part += down;
    //         down = (n-j)*(as[j]-as[j-1]);
    //     }
    // }
    // bool c = up <= down;
    // if (i+1 == j) {
    //     if (c) {
    //         ++i;
    //         down -= up;
    //         part = up;
    //         up = (i-m)*(as[i]-as[i-1]);
    //     } else {
    //         --j;
    //         up -= down;
    //         part = down;
    //         down = (n-j)*(as[j]-as[j-1]);
    //     }
    // }
    // ll x = bs(i-m,n-j,as[i]-as[i-1], c, part);
    // cout << as[i]+x;
}
