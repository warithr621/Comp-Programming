// COCI 2021/2022 R2 P1

#include <bits/stdc++.h>
using namespace std;

void print(int s, int ss, int sss, string title) {
	cout << s;
	if (ss != 0) cout << '.' << ss;
	if (sss != 0) cout << '.' << sss;
	cout << ' ' << title << '\n';
}

int main() {
	int N; cin >> N;
	int sec = 0, subsec = 0, subsubsec = 0;
	for (int i = 0; i < N; i++) {
		string s, t; cin >> s >> t;
		if (s == "section") {
			++sec;
			subsec = 0;
			subsubsec = 0;
		} else if (s == "subsection") {
			++subsec;
			subsubsec = 0;
		} else ++subsubsec;
		print(sec, subsec, subsubsec, t);
	}
}