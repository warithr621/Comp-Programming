%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)

void solve() <%
    //code
    int n, k; cin >> n >> k;
    vi a(n);
    for (int &x : a) cin >> x;
    vi b(n);
    for (int i = 0; i < n; i++) {
        b[i] = __builtin_popcount(a[i]);
    }
    // increment as much as you can every time
    // more optimal to increment early than later
    for (int bit = 0; bit < 63 && k != 0; bit++) {
    	for (int i = 0; i < n && k != 0; i++) {
            // see if we can jump a[i] to the next bit
            int check = 1LL << bit;
            if (a[i] & check) continue;
            if (k >= check) {
                // cout << "Adding " << check << " to a[" << i << "]\n";
                k -= check;
                b[i]++;
            }
        }
    }
    // for (int x : b) cout << x << ' ';
    // cout << '\n';
    cout << accumulate(b.begin(), b.end(), 0LL) << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
