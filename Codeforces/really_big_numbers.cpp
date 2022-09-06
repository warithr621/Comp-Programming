// https://codeforces.com/contest/817/problem/C

%:include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() <%
	int n,s; cin >> n >> s;

	//binary search to find the smallest 'n'
	int L = 1, R = n;
	while(L < R) {
		// cout << L << ' ' << R << '\n';
		int M = L + (R - L + 1) / 2;
		int tmp = M, tot = 0;
		while(tmp != 0) {
			tot += tmp % 10;
			tmp /= 10;
		}
		if (M - tot < s) {
			//not really big
			L = M;
		} else {
			R = --M;
		}
	}
	// cout << L << "moo\n";

	++L; //funny

	//test to see if 'L' is really big
	int tmp = L, tot = 0;
	while(tmp != 0) {
		tot += tmp%10;
		tmp /= 10;
	}

	if (L - tot >= s && L <= n) {
		//'L' is really big
		cout << n-L+1 << '\n';
	} else cout << "0\n";
%>