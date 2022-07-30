// CSES Sum of Two Values

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double;
typedef vector<int> vi;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define s(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define bs(v, s) binary_search(v.begin(), v.end(), s)
#define minvec(v) *min_element(v.begin(), v.end())
#define maxvec(v) *max_element(v.begin(), v.end())
#define mp make_pair
#define pb(x) push_back(x)
#define fst first
#define sec second
#define foru(i, n, ty, x) for (int i = n; i < ty; i += x)
#define ford(i, n, ty, x) for (int i = n; i >= ty; i -= x)
#define forn(i, ty) foru(i, 0, ty, 1)
 
void setIO(string name) {
	cin.tie(0)->sync_with_stdio(0);
	if (name != "") {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}
 
bool prime(int n) {
	bool p = true;
	for (int i = 2; i <= pow(n, 0.5); i++) {
		if (n % i == 0) {
			p = false; break;
		}
	}
    if (n <= 1) p = false;
	return p;
}
 
int gcd(int x, int y) {
	if (x == 0) return y;
	return gcd(y % x, x);
}
 
int lcm(int x, int y) {
	return x * y / gcd(x, y);
}
 
int p(int x, int y, int p) { 
	int ans = 1;
	x = x % p;
	if (x == 0) return 0;
	while (y > 0) { 
		if (y % 2 == 1) ans = (ans*x) % p;
        y /= 2;
        x = (x*x) % p; 
    } 
    return ans; 
}
 
int fib(int n) {
	int a = 0, b = 1, c, i;
	if(n == 0) return a;
	for(i = 2; i <= n; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return b;
}
 
vector<int> sieve(int n) {
    bool prime[n + 1];
    memset(prime, true, sizeof(prime));
 
    for (int p = 2; p * p <= n; p++) {
        if (prime[p] == true) {
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
    }
 
    vector<int> ans;
 
    for(int p = 2; p <= n; ++p) {
        if (prime[p]) ans.pb(p);
    }
    return ans;
}
 
int find(vi b, int x) {
    forn(i, b.size()) if (b[i] == x) return ++i;
    return -1;
}
 
int find(vi b, int x, int lol) {
    bool y = false;
    forn(i, b.size()) {
        if (b[i] == x && y) return ++i;
        else if (b[i] == x && y == false) y = true;
    }
    return -1;
}
 
void solve() {
    int n, x; cin >> n >> x;
    vi a(n), b(n);
    forn(i, n) cin >> a[i];
    b = a;
    s(a);
    int L = 0, R = n-1;
    while(a[L] + a[R] != x && L < n && R >= 0) {
        if (a[L] + a[R] > x) --R;
        else ++L;
    }
    if (L == R || L == n || R == -1) cout << "IMPOSSIBLE\n";
    else {
        if (a[L] == a[R]) cout << find(b, a[L]) << ' ' << find(b, a[R], 1) << '\n';
        else cout << find(b, a[L]) << ' ' << find(b, a[R]) << '\n';
    }
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}