// USACO Trainer's "Your Ride is Here"

/*
ID: warithr1
LANG: C++11
TASK: ride
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("ride.in", "r", stdin);
	freopen("ride.out", "w", stdout);

	string comet, group;
	cin >> comet >> group;

	int cnum = 1, gnum = 1;
	for (int i = 0; i < comet.length(); i++) {
		cnum *= (comet[i] - 'A' + 1);
	}
	for (int i = 0; i < group.length(); i++) {
		gnum *= (group[i] - 'A' + 1);
	}

	if (cnum % 47 == gnum % 47) {
		cout << "GO\n";
	} else {
		cout << "STAY\n";
	}
}