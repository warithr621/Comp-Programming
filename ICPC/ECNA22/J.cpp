#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	// i think this is just simul hell
	vector<string> cards;
	for (int skib = 0; skib < 52; skib++) {
		string s; cin >> s;
		cards.push_back(s);

		// idx of the removal (like the latter of the two/four) and the number of cards we remove
		while (true) {
			int idx = -1, no = 0;
			// cout << cards.size();
			// for (string s : cards) {
			// 	cout << ' ' << s;
			// }
			// cout << '\n';
			// let's check if we can ever remove a card
			for (int i = (int)cards.size() - 1; i - 3 >= 0; i--) {
				int removed = 0;
				if (cards[i][1] == cards[i-3][1]) removed = 2;
				if (cards[i][0] == cards[i-3][0]) removed = 4;
				if (removed > no) {
					idx = i-3;
					no = removed;
				}
			}
			// cout << idx << endl;
			if (idx == -1) break;
			else {
				if (no == 4) {
					cards.erase(cards.begin() + idx, cards.begin() + idx + 4);
				} else {
					cards.erase(cards.begin() + idx);
					cards.erase(cards.begin() + idx + 2);
				}
			}

		}
	}

	cout << cards.size();
	for (string s : cards) {
		cout << ' ' << s;
	}
	cout << '\n';
}