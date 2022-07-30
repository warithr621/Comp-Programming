// CSES Forest Queries

#include <bits/stdc++.h>
using namespace std;
#define int long long

int32_t main() {
	int n,q; cin >> n >> q;
	vector<string> v(n); //forest
	for (int i = 0; i < n; i++) cin >> v[i];
	int p[n+1][n+1]; //2D psums no way??????
	p[0][0] = 0;
	for (int i = 1; i <= n; i++) {
	    for (int j = 1; j <= n; j++) {
	        p[i][j] = p[i][j-1] + p[i-1][j] - p[i-1][j-1] + (v[i-1][j-1] == '*' ? 1 : 0);
	    }
	}
	while(q--) {
	    int x1, y1, x2, y2; cin >> x1 >> y1 >> x2 >> y2;
	    --x1; --y1;
	    cout << p[x2][y2] - p[x1][y2] - p[x2][y1] + p[x1][y1] << '\n';
	}
}
