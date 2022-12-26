// 2022 Dec Bronze P3

#include <bits/stdc++.h>
using namespace std;

int T, N, M;
pair<string, bool> A[200];
bool match[200];

void solve() {
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		string S; bool B;
		cin >> S >> B;
		A[i] = {S, B};
	}

	memset(match, false, M);

	while (true) {
		bool ifState = false;

		for (int bit = 0; bit < N; ++bit) {
			if (ifState) break;
			for (char v : {'0', '1'}) {
				if (ifState) break;
				for (bool b : {false, true}) {
					if (ifState) break; // lol this is fun to repeat

					bool exists = false, consistent = true;
					for (int i = 0; i < M; ++i) {
						if (match[i]) continue; // alr matched this

						if (A[i].first[bit] == v) {
							exists = true;
							if (A[i].second != b) {
								consistent = false;
							}
						}
					}

					if (exists and consistent) {
						ifState = true;
						// cout << bit << ' ' << v << '\n';
						for (int i = 0; i < M; i++) {
							if (A[i].first[bit] == v) match[i] = true;
						}
					}
				}
			}
		}
		
		if (!ifState) break;
	}

	bool yay = true;
	for (int i = 0; i < M; i++) yay &= match[i];
	cout << (yay ? "OK\n" : "LIE\n");
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> T;
	while(T--) solve();
}