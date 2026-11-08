#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	string C1, C2; cin >> C1 >> C2;
	int len = C2.size();
	// RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET
	// 2 holes: B
	// 1 hole: A D O P Q R
	// 0 holes: E G I L N T U V W Y
	// in the shape of C1, but must contain C2 in it
	vector<int> holes = {1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
	vector<vector<string>> letters;
	for (char c : C1) {
		vector<string> things;
		int num = holes[c - 'A'];
		if (num == 0) {
			things = vector<string>(5, "Z");
		} else if (num == 1) {
			things = {C2,
				"Z" + string(len-2, '.') + "Z",
				"Z" + string(len-2, '.') + "Z",
				"Z" + string(len-2, '.') + "Z",
				C2
			};
		} else if (num == 2) {
			things = {C2,
				"Z" + string(len-2, '.') + "Z",
				C2,
				"Z" + string(len-2, '.') + "Z",
				C2
			};
		}
		letters.push_back(things);
	}

	for (int row = 0; row < 5; row++) {
		for (int i = 0; i < letters.size(); i++) {
			cout << letters[i][row];
			if (i + 1 != letters.size()) cout << '.';
		}
		cout << '\n';
	}
}