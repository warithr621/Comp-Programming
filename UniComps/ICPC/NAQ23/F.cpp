// 2023 NAQ: Is Y a Vowel?

#include <bits/stdc++.h>
using namespace std;

int main() {
	string S; cin >> S;
	int v = 0, y = 0;
	for (char c : S) {
	    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ++v;
	    if (c == 'y') ++y;
	}
	cout << v << ' ' << (v+y) << '\n';
}
