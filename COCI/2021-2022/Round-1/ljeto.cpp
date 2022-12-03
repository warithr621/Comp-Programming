// COCI 2021/2022 R1 P1

#include <bits/stdc++.h>
using namespace std;

vector<int> pine[4], blue[4];
int N, T, A, B, sc_p = 0, sc_b = 0;

int main() {
	cin >> N;
	while(N--) {
		cin >> T >> A >> B;
		if (A <= 4) pine[A-1].push_back(T);
		else blue[A-5].push_back(T);
	}

	for (vector<int> v : pine) {
		for (int i = 0; i < (int) v.size(); i++) {
			sc_p += 100;
			if (i != 0 && v[i] - v[i-1] <= 10) sc_p += 50;
		}
	}
	for (vector<int> v : blue) {
		for (int i = 0; i < (int) v.size(); i++) {
			sc_b += 100;
			if (i != 0 && v[i] - v[i-1] <= 10) sc_b += 50;
		}
	}

	cout << sc_p << ' ' << sc_b << '\n';
}