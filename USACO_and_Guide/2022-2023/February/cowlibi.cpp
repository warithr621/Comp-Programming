#include <bits/stdc++.h>
using namespace std;
#define int long long

vector< array<int, 3> > crime;
int G, N, X, Y, T;

bool cmp(array<int, 3> A, array<int, 3> B) {
    return A[2] < B[2];
}

bool safe(array<int, 3> loc) {
    int dx = loc[0] - X, dy = loc[1] - Y, ti = T - loc[2];
    return dx * dx + dy * dy > ti * ti;
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> G >> N;
    for (int i = 0; i < G; i++) {
            cin >> X >> Y >> T;
            crime.push_back({X, Y, T});
    }
    sort(crime.begin(), crime.end(), cmp);
    int ans = 0;
    
    
    while(N--) {
        cin >> X >> Y >> T;
        array<int, 3> search = {INT_MIN, INT_MIN, T};
        auto it = lower_bound(crime.begin(), crime.end(), search, cmp);
        
        if (it != crime.end() && (*it)[2] == T) {
            if (X != (*it)[0] || Y != (*it)[1]) ans++;
        } else {
            if (it == crime.begin()) {
                if (safe(*it)) ans++;
            } else if (it == crime.end()) {
                if (safe(*(--it))) ans++;
            } else {
                if (safe(*it) or safe(*(--it))) ans++;
            }
        }
    }
    cout << ans << '\n';
}