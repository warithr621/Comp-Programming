// 2022 Open Silver P3

#include <iostream>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	string s; cin >> s;
	int n = s.size();
	int pc[n+1], po[n+1], pw[n+1];
	pc[0] = po[0] = pw[0] = 0;
	for (int i = 1; i <= n; i++) {
		pc[i] = pc[i-1] + (s[i-1] == 'C' ? 1 : 0);
		po[i] = po[i-1] + (s[i-1] == 'O' ? 1 : 0);
		pw[i] = pw[i-1] + (s[i-1] == 'W' ? 1 : 0);	
	}
	// for (int i = 0; i <= n; i++) {
	// 	cout << pc[i] << ' ' << po[i] << ' ' << pw[i] << '\n';
	// }
	int q; cin >> q;
	while(q--) {
		int L, R; cin >> L >> R;
		int C = pc[R] - pc[L-1];
		int O = po[R] - po[L-1];
		int W = pw[R] - pw[L-1];
		if ((O + W) % 2 == 0 && (C + O) % 2 == 1) cout << "Y";
		else cout << "N";
		// cout << '\n' << C << ' ' << O << ' ' << W << '\n';
	}
}
