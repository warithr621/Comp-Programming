/*
Im Nayeon
Yoo Jeongyeon
Momo Jjang
Sana Jjang
Park Jihyo
Mina Jjang
Kim Dahyun
Son Chaeyoung
Chou Tzuyu
One in a million
눈부시게 사랑해
트와이스 !!
*/

%:include <bits/stdc++.h>
using namespace std;
// %:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)

int gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}

void solve() <%
    //code
    int n,q; cin >> n >> q;
    int a[n];
    for (int &x : a) {
    	cin >> x;
    }
    // sparse tables are sus
    vector<vi> sparse(n-1, vi(20, 0));
    for (int i = 0; i < (n-1); i++) {
    	sparse[i][0] = abs(a[i] - a[i+1]);
    }
    for (int j = 1; (1 << j) <= (n-1); j++) {
    	for (int i = 0; i <= (n-1) - (1 << j); i++) {
    		sparse[i][j] = gcd(sparse[i][j-1], sparse[i + (1 << (j-1))][j - 1]);
    	}
    }


    for(;q--;) {
    	int l,r; cin >> l >> r;
    	// let a = {q, w, e, r, t}
    	// diff = {q-w, w-e, e-r, r-t}
    	// to answer [1,3], we want gcd(w-e, e-r)
    	if (l == r) cout << "0 ";
    	else {
    		l -= 1; r -= 2;
    		int p = (int) log2(r - l + 1);
    		cout << gcd(sparse[l][p], sparse[r - (1<<p) + 1][p]) << ' ';
    	}
    }
    cout << '\n';

%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
