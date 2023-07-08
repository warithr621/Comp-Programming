// https://codeforces.com/contest/1846/problem/E1

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
bool a[(int) (1e6+5)];
 
void solve() <%
    //code
    int n; cin >> n;
    // trying to find k > 1 such that 1 + k + k^2 + ... = n
    // precompute?? darn
    cout << (a[n] ? "YES" : "NO") << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    
    // remember that the biggest k is that such that 1 + k + k^2 <= 1e6, or k = 999
    // also remember that for k = 2, 1 + k + k^2 + ... + k^p <= 1e6 if p is at most 18
    // thus we don't need to loop a lot
    for (int k = 2; k < 1000; k++) {
        int cur = 1 + k + k*k, p = 3;
        a[cur] = true;
        for(;;) {
            cur += pow(k, p);
            if (cur > (1e6)) break;
            a[cur] = true;
            ++p;
        }
    }
    
    int T; cin >> T;
    while (T --> 0) solve();
}