// https://codeforces.com/contest/1772/problem/E

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) reverse(v.begin(), v.end())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() <%
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];

    // First wants to get it 1,2,...
    // Second wants to get it N,N-1...

    // red HAVE to keep their position
    // so each person needs to color some numbers blue to rearrange them
    // also some numbers probably need to be colored by both

    int blue_f = 0, blue_s = 0, blue_b = 0; // first, second, both
    for (int i = 0; i < n; i++) {
        if (i + 1 != a[i] && n-i != a[i]) ++blue_b;
        else {
            if (i + 1 != a[i]) ++blue_f;
            if (n - i != a[i]) ++blue_s;
        }
    }

    // First or Second can only win if they shutdown the game, probably
    // First needs to color their numbers in blue_s moves
    // Second needs to color their numbers in blue_f moves

    if (blue_f + blue_b <= blue_s) cout << "First\n";
    else if (blue_s + blue_b < blue_f) cout << "Second\n"; // < not <= b/c they go second
    else cout << "Tie\n";
    /* I actually can't imagine when a tie would happen ngl
    but oh well if it's in the problem surely it happens right!! */
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}