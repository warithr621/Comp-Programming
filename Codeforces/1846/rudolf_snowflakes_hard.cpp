// https://codeforces.com/contest/1846/problem/E2

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
set<int> a;
 
void solve() <%
    //code
    int n; cin >> n;
    // trying to find k > 1 such that 1 + k + k^2 + ... = n
    // precompute?? darn
    string ans = "NO";
    if (a.count(n)) ans = "YES";
    // now check for the k^2 + k + 1 case, in case ans is still NO but it shouldn't be
    // solving k^2 + k + (1-n) = 0, a = 1, b = 1, c = (1-n)
    
    int disc = 4 * n - 3;
    double root = (-1.0 + sqrt(disc)) / 2;
    if ((int) root == root and root > 1) ans = "YES";
    cout << ans << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    
    // remember that the biggest k is that such that 1 + k + k^2 <= 1e18, or k = 1e9 - 1
    // also remember that for k = 2, 1 + k + k^2 + ... + k^p <= 1e18 if p is at most 58
    // ok now we do need to loop a lot, darn it
    // or solve all p >= 3 cases instead? that makes k at most 1e6 - 1 instead which works way better
    // and then the p = 2 case is just solve for integer k such that k^2 + k + 1 = n
    // also maybe pow is slow im too lazy to think
    for (int k = 2; k < 1e6; k++) {
        int cur = 1 + k + k*k, p = k * k * k;
        for(;;) {
            cur += p;
            if (cur > 1e18) break;
            a.insert(cur);
            if (p > 1e18 / k) break; // overflow ig idk
            p *= k;
        }
    }
    
    int T; cin >> T;
    while (T --> 0) solve();
}