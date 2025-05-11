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
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)

int gcd(int a, int b) {
	return b == 0 ? a : gcd(b,a%b);
}

pii extendgcd(int a, int b) {
	if (b == 0) return {1, 0};
	auto [x, y] = extendgcd(b, a % b);
	return {y, x - (a / b) * y};
}

int ceildiv(int x, int y) {
	return x / y + (x % y != 0 && x > 0 ? 1 : 0);
}

int floordiv(int x, int y) {
	return x / y - (x % y != 0 && x < 0 ? 1 : 0);
}

void solve() <%
    //code
    int n,w,b; cin >> n >> w >> b;
    if (w == 0 && b == 0) {
    	cout << (n == 0 ? 1 : 0) << '\n';
    	return;
    } else if (w == 0) {
    	cout << (n % b == 0 ? 1 : 0) << '\n';
    	return;
    } else if (b == 0) {
    	cout << (n % w == 0 ? 1 : 0) << '\n';
    	return;
    }
    int ans = 0;
    if (n % gcd(w,b) != 0) {
    	cout << "0\n"; // definition of Diophantine
    	return;
    }
    int g = gcd(n, gcd(w, b));
    n /= g; w /= g; b /= g;
    auto [a0, b0] = extendgcd(w, b);
    a0 *= n; b0 *= n;
    int astep = b, bstep = w;
    int kmin = ceildiv(-a0, astep), kmax = floordiv(b0, bstep);
    cout << max(0LL, kmax - kmin + 1) << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>