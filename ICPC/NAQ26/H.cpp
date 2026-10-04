#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	srand(time(0));
	int t; cin >> t;
	while (t--) {
		for (int op = 0; op < 100; op++) {
			char guess = (rand() % 2 ? 'T' : 'F');
			cout << guess << endl;
			string response;
			if (!(cin >> response) || response == "-1") {
				return 0;
			}
			guess = (response[0] == 'T' ? 'F' : 'T');
			cout << guess << endl;
			if (!(cin >> response) || response == "-1") {
				return 0;
			}
		}
	}
	return 0;
}