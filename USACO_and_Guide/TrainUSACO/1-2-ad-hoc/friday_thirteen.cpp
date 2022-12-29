// USACO Trainer's "Friday the Thirteenth"

/*
ID: warithr1
LANG: C++11
TASK: friday
*/

int dm[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

bool leap(int y) {
	return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
}

int days_in_month(int year, int month) {
	if (month == 1) {
		// february
		return dm[month] + leap(year);
	} else {
		return dm[month];
	}
}

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("friday.in", "r", stdin);
	freopen("friday.out", "w", stdout);

	int N; cin >> N;
	vector<int> days(7, 0);

	int cur_day = 0; // 0 = saturday
	for (int i = 1900; i < 1900+N; ++i) {
		for (int m = 0; m < 12; ++m) {
			days[cur_day]++;
			cur_day = (cur_day + days_in_month(i, m)) % 7;
		}
	}

	for (int i = 0; i < 7; ++i) {
		cout << (i == 0 ? "" : " ") << days[i];
	}
	cout << '\n';
}