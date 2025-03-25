%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(x) sort(x.begin(), x.end())
%:define rev(x) sort(x.rbegin(), x.rend())
%:define pb(x) push_back(x)
%:define forn(i, n) for(int i = 0; i < n; ++i)
%:define fst first
%:define sec secomd
 
const int MAXN = 1e7;
 
void twice(vector<int>& primes) <%
    // brickfest, darn (also me when & passes)
    //code
    int n; cin >> n;
    int ans = 0;
    for (int p : primes) {
        if (p > n) break;
        ans += n / p;
    }
    cout << ans << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
 
    // first, do some sieving
    vector<bool> p(MAXN + 1, true);
    p[0] = p[1] = false;
    for (int i = 2; i * i <= MAXN; i++) {
        if (p[i]) {
            for (int j = i * i; j <= MAXN; j += i) {
                p[j] = false;
            }
        }
    }
    vector<int> primes;
    for (int i = 2; i <= MAXN; i++) {
        if (p[i]) primes.pb(i);
    }
 
    int T = 1;
    cin >> T;
    while(T--) twice(primes);
}
