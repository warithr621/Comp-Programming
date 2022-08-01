// CSES Coin Combinations II
 
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#define int long long
#define vi vector<int>
#define MOD 1000000007
using namespace std;
 
int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
 
	int n,x; cin >> n >> x;
	vi a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	vi dp(x+1, 0);
	dp[0] = 1;
	for (int i = 0; i < n; i++) {
	    for (int w= 0; w <= x; w++) {
	        if (w - a[i] >= 0) {
	            dp[w] = (dp[w] + dp[w - a[i]]) % MOD;
	        }
	    }
	}
	cout << dp[x] << '\n';
}