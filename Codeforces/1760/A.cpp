// https://codeforces.com/contest/1760/problem/A

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() {
    //code
    int a,b,c; cin >> a >> b >> c;
	int x = max(a, max(b,c));
	int y = min(a, min(b, c));
	cout << -(x+y-a-b-c) << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}