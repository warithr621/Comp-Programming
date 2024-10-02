// 2022 NAQ: Smallest Calculated Value

#include <bits/stdc++.h>
using namespace std;

int calc(int A, int op1, int B, int op2, int C) {
    // + - * /
    int cur = 0;
    if (op1 == 0) {
        cur = A + B;
    } else if (op1 == 1) {
        cur = A - B;
    } else if (op1 == 2) {
        cur = A * B;
    } else {
        if (B == 0 || A % B != 0) return (int) (1e9) + 1;
        cur = A / B;
    }
    if (op2 == 0) {
        cur += C;
    } else if (op2 == 1) {
        cur -= C;
    } else if (op2 == 2) {
        cur *= C;
    } else {
        if (C == 0 || cur % C != 0) return (int) (1e9) + 1;
        cur /= C;
    }
    // cout << op1 << ' ' << op2 << ' ' << cur << '\n';
    return cur;
}

int main() {
	int A, B, C; cin >> A >> B >> C;
	int ans = (int) (1e9) + 1;
	for (int mask = 0; mask < 16; mask++) {
	    int op1 = mask % 4;
	    int op2 = (mask - op1) / 4;
	    int v = calc(A, op1, B, op2, C);
	    if (v >= 0) ans = min(ans, v);
	   // cout << op1 << ' ' << op2 << '\n';
	}
	cout << ans;
}
