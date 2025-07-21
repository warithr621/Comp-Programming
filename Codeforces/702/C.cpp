// https://codeforces.com/contest/702/problem/C

#include <iostream>
#include <vector>
#include <algorithm>
#define int long long
using namespace std;

int n,m;
vector<int> a,b;

bool dist(int d) {
	int aptr = 0, bptr = 0;
	while(aptr < n && bptr < m) {
		//first, check if aptr is in the range of bptr
		if (abs(a[aptr] - b[bptr]) <= d) {
			//this is fine, so just increment aptr
			++aptr; continue;
		}

		/*since aptr is now not in the range,
		check to see if a[aptr] > b[bptr]
		if it is, then we can just increment bptr */
		if (a[aptr] > b[bptr]) ++bptr;
		else {
			//there's no way we can reach aptr, so return false
			return false;
		}
	}
	return aptr == n;
}

int32_t main() {
	cin >> n >> m;
	a.resize(n); b.resize(m);
	for (int i = 0; i < n; i++) cin >> a[i];
	for (int i = 0; i < m; i++) cin >> b[i];
	int L = 0, R = 2000000001;
	while (L < R) {
		int M = (L + R + 1) / 2;
		if (dist(M)) R = --M;
		else L = M;
	}
	/*ok since the prog is being slightly weird
	make sure that the towers arent already on all the cities*/
	int city = 0, tower = 0, cnt = 0;
	while(city < n && tower < m) {
		if (a[city] == b[tower]) {
			++city; ++cnt;
		} else if (a[city] > b[tower]) ++tower;
		else ++city;
	}
	cout << (cnt == n ? 0 : ++L) << '\n';
}
