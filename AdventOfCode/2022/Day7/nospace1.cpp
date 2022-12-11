// AoC 2022 D7

#include <bits/stdc++.h>
#define int long long
using namespace std;

string S;
map<string, int> sz;
vector<string> vec;

void solve() {
	if (S[0] == '$') {
		S = S.substr(2);
		if(S[0] == 'c') {
			S = S.substr(3);
			if(S == "..") vec.pop_back();
			else vec.push_back(S);
		}
	} else {
		if (S[0] != 'd') {
			int n = 0;
			for (int i = 0; i < S.length(); ++i){
				if (!isdigit(S[i])) break;
				n = n * 10 + S[i] - '0';
			}
			string tmp;
			for (int i = 0; i < vec.size(); i++) {
				tmp += vec[i];
				sz[tmp] += n;
			}
		}
	}
}

signed main() {
	vec.push_back("/");
	while (getline(cin, S)) {
		if (S.size() == 0) break;
		solve();
	}
	int rem = sz["/"] - 40000000, ans = 0;
	for (pair<string, int> i : sz) {
		if(i.second <= 100000){
			ans += i.second;
		}
	}
	cout << ans << '\n';
}