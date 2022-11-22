//Problem: https://codeforces.com/contest/1501/problem/A

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<ld> vld;
typedef vector<ll> vll;
typedef vector<string> vs;
typedef vector<char> vc;
typedef vector<bool> vb;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define pi 3.141592653589793
#define s(v) sort(v.begin(), v.end())
#define sped cin.tie(0)->sync_with_stdio(0)
#define rev(v) sort(v.rbegin(), v.rend())
#define bs(v, s) binary_search(v.begin(), v.end(), s)
#define minvec(v) *min_element(v.begin(), v.end())
#define maxvec(v) *max_element(v.begin(), v.end())
#define mp make_pair
#define pb(x) push_back(x)
#define fst first
#define sec second
#define foru(i, n, k, x) for (int i = n; i < k; i += x)
#define ford(i, n, k, x) for (int i = n; i >= k; i -= x)
#define forn(i, k) foru(i, 0, k, 1)
#define sp setprecision(15)


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

vi sieve(int n) {
    bool prime[n + 1];
    memset(prime, true, sizeof(prime));
 
    for (int p = 2; p * p <= n; p++) {
        if (prime[p] == true) {
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
    }
 
    vi ans;

    for(int p = 2; p <= n; ++p) {
        if (prime[p]) ans.pb(p);
    }
    return ans;
}

void solve() {
    int n; cin >> n;
    vi a(n+1), b(n+1), t(n+1);
    for(int i = 1; i <= n; i++) cin >> a[i] >> b[i];
    int ans = 0;
    for(int i = 1; i <= n; i++) {
        cin >> t[i];
        ans += a[i] - b[i-1] + t[i];
        if (i == n) break;
        ans = max(ans + (b[i] - a[i] + 1) / 2, b[i]);
    }
    cout << ans << '\n';
}
 
int main() {
    sped;
    int t; cin >> t; while(t--)
    solve();
}