// https://codeforces.com/contest/1770/problem/B

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) reverse(v.begin(), v.end())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)
#define fst first
#define sec second

int cost(vi a, int k) {
    int ans = -1;
    for (int i = 0; i+k-1 < a.size(); i++) {
        int mn = *min_element(a.begin() + i, a.begin() + i + k);
        int mx = *max_element(a.begin() + i, a.begin() + i + k);
        ans = max(ans, mn+mx);
    }
    return ans;
}

int brute(int n, int k) {
    // weird brute force to fix my stuff
    vi a(n);
    forn(i, n) a[i] = i+1;
    int ans = 2e5;
    do {
        ans = min(cost(a,k), ans);
    } while (next_permutation(a.begin(), a.end()));

    return ans;
}

vi walrus(int n, int k) {
    vi ans(n);
    if (n % 2 == 0) {
        int cur = n;
        for (int i = 0; i < n; i += 2) {
            ans[i] = cur;
            ans[i+1] = n - cur + 1;
            --cur;
        }
    } else {
        ans[0] = n;
        int cur = 1;
        for (int i = 1; i < n; i += 2) {
            ans[i] = cur;
            ans[i+1] = n - cur;
            ++cur;
        }
    }
    return ans;
}

void solve() <%
    //code
    int n,k; cin >> n >> k;
    vi ans = walrus(n,k);
    for (int i : ans) cout << i << ' ';
    cout << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}