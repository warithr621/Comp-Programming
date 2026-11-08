#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

int digit(char c) {
	if ('0' <= c && c <= '9') return c - '0';
	else return (c - 'A') + 10;
}

string conv(int x) {
	// convert to hex :(
	if (x == 0) return "0";
	vector<char> vec;
	while (x != 0) {
		int d = x % 16;
		if (d <= 9) vec.push_back('0' + d);
		else vec.push_back('A' + (d - 10));
		x >>= 4;
	}
	reverse(vec.begin(), vec.end());
	string s = "";
	for (char c : vec) s += c;
	return s;
}

signed main() {
	int least = 0, most = 0;
	int n; cin >> n;
	while (n--) {
		string s; cin >> s;
		if (s.size() == 1) {
			char c = s[0];
			if (c == '0' || c == 'D') {
				least += digit('0');
				most += digit('D');
			} else if (c == '8' || c == 'B') {
				least += digit('8');
				most += digit('B');
			} else {
				least += digit(c);
				most += digit(c);
			}
			continue;
		}
		int pv = 1 << (4 * (s.size()-1));
		for (int i = 0; i < s.size(); i++) {
			char c = s[i];
			if (c == '0' || c == 'D') {
				least += pv * digit(i == 0 ? 'D' : '0');
				most += pv * digit('D');
			} else if (c == '8' || c == 'B') {
				least += pv * digit('8');
				most += pv * digit('B');
			} else {
				least += pv * digit(c);
				most += pv * digit(c);
			}
			pv >>= 4;
		}
	}
	cout << conv(most) << '\n' << conv(least) << '\n';
}